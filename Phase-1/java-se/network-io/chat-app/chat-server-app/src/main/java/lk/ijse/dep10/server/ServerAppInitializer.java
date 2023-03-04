package lk.ijse.dep10.server;

import com.sun.nio.file.ExtendedOpenOption;
import lk.ijse.dep10.server.model.User;
import lk.ijse.dep10.shared.Dep10Headers;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerAppInitializer {
    private static volatile ArrayList<User> userList = new ArrayList<>();
    private static volatile String chatHistory = "";

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server is listening to 5050");

        while (true){
            System.out.println("Waiting for an incoming connection");
            Socket localSocket = serverSocket.accept();
            User user = new User(localSocket);
            userList.add(user);
            System.out.println("New connection: " + user.getRemoteIpAddress());
            sendChatHistory(user);
            broadcastLoggedUsers();
            new Thread(()->{
                try {
                    ObjectInputStream ois = user.getObjectInputStream();
                    while (true){
                        Dep10Message msg = (Dep10Message) ois.readObject();
                        if (msg.getHeader() == Dep10Headers.MSG){
                            chatHistory += String.format("%s : %s \n",user.getRemoteIpAddress(),msg.getBody());
                            broadcastChatHistory();
                        }
                        else if (msg.getHeader() == Dep10Headers.EXIT){
                            userList.remove(user);
                            if (user.getLocalSocket().isConnected()){
                                user.getLocalSocket().close();
                            }
                            broadcastLoggedUsers();
                            return;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    if (e instanceof EOFException){
                        if (userList.contains(user)){
                            userList.remove(user);
                            broadcastLoggedUsers();
                        }
                    }
                    e.printStackTrace();
                }
            }).start();
        }
    }
    private static void sendChatHistory(User user) throws IOException {
        ObjectOutputStream oos = user.getObjectOutputStream();
        Dep10Message msg = new Dep10Message(Dep10Headers.MSG, chatHistory);
        oos.writeObject(msg);
        oos.flush();
    }

    private static void broadcastLoggedUsers(){
        ArrayList<String> ipAddressList = new ArrayList<>();
        for (User user : userList) {
            ipAddressList.add(user.getRemoteIpAddress());
        }
        for (User user : userList) {
            new Thread(()->{
                try {
                    ObjectOutputStream oos = user.getObjectOutputStream();
                    Dep10Message msg = new Dep10Message(Dep10Headers.USERS, ipAddressList);
                    oos.writeObject(msg);
                    oos.flush();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
    private static void broadcastChatHistory(){
        for (User user : userList) {
            new Thread(()->{
                try {
                    ObjectOutputStream oos = user.getObjectOutputStream();
                    oos.writeObject(new Dep10Message(Dep10Headers.MSG,chatHistory));
                    oos.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
