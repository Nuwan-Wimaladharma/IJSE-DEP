package lk.ijse.dep10.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.8.199", 5050);
        System.out.println("Connected with the server");
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter something to send: ");
            String input = scanner.nextLine();
            String input2 = "Nuwan: " + input;
            os.write(input2.getBytes());
            os.flush(); //optional
        }
    }
}
