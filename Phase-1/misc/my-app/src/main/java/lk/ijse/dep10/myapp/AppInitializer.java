package lk.ijse.dep10.myapp;

import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("My friend, please enter your name: ");
        var name = scanner.nextLine();
        System.out.printf("I am sorry %s, you are hacked",name);
    }
}
