package miscelaneous;

import java.util.Scanner;

public class StandardStreams {
    public static void main(String[] args) {
        System.out.println("Nuwan"); //standard output is screen
        System.err.println("Error"); //standard error is screen

        Scanner scanInput = new Scanner(System.in); //System.in is the source & scanInput is a local variable
        System.out.print("Enter your name: ");
        String input = scanInput.nextLine(); // input also a local variable
        System.out.print("Hi..!," + input);

    }
}
