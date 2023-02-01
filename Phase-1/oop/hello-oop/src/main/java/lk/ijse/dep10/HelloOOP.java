package lk.ijse.dep10;

import javax.swing.*;
import java.util.Scanner;

public class HelloOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //java SE
        MyClass myClass = new MyClass(); //Mine
        String myStr = new String(); //java SE

        JFrame myFrame = new JFrame("My Frame"); //java SE
        myFrame.setSize(500,500);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
