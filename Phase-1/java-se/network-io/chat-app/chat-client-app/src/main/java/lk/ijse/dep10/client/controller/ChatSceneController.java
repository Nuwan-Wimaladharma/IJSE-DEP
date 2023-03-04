package lk.ijse.dep10.client.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.dep10.shared.Dep10Headers;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatSceneController {

    public TextArea txtChatHistory;
    @FXML
    private ListView<String> lstMessages;

    @FXML
    private ListView<String> lstUsers;

    @FXML
    private TextField txtMsg;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public void initialize(){
        connect();
        readServerResponses();
        Platform.runLater(()->{
            closeSocketOnStageCloseRequest();
        });
    }
    private void readServerResponses(){
        new Thread(()->{
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                while (true){
                    Dep10Message msg = (Dep10Message) ois.readObject();
                    if (msg.getHeader() == Dep10Headers.USERS){
                        ArrayList<String> ipAddressesList = (ArrayList<String>) msg.getBody();
                        Platform.runLater(()->{
                            lstUsers.getItems().clear();
                            lstUsers.getItems().addAll(ipAddressesList);
                        });
                    }
                    else if (msg.getHeader() == Dep10Headers.MSG){
                        Platform.runLater(()->{
                            txtChatHistory.setText(msg.getBody().toString());
                        });
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                if (!socket.isClosed() || e instanceof EOFException){
                    Platform.exit();
                    return;
                }
                e.printStackTrace();
            }
        }).start();

    }
    private void connect(){
        try {
            socket = new Socket("192.168.8.165",5050);
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to connect to the server").showAndWait();
            Platform.exit();
        }
    }
    private void closeSocketOnStageCloseRequest(){
        txtMsg.getScene().getWindow().setOnCloseRequest(event -> {
            try {
                oos.writeObject(new Dep10Message(Dep10Headers.EXIT,null));
                oos.flush();
                if (socket.isConnected()) socket.close();
            }
            catch (IOException e){
                throw new RuntimeException();
            }
        });
    }

    public void txtMsgOnAction(ActionEvent actionEvent) {
        try {
            Dep10Message msg = new Dep10Message(Dep10Headers.MSG, txtMsg.getText());
            oos.writeObject(msg);
            oos.flush();
            txtMsg.clear();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to connect to the server, try again").show();
            e.printStackTrace();
        }
    }
}

