package miscelaneous;

import java.util.Scanner;

public class StandardStreams4 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter something: ");
        String input = scanner.next(); //get only one token(separated by space) nextline statements takes an entire line
        System.out.println(input);

        String input2 = scanner.next();
        System.out.println(input2);

        var scanner2 = new Scanner(System.in);
        System.out.println("Enter something: ");
        scanner2.useDelimiter("-");
        String input3 = scanner2.next();
        System.out.println(input3);
    }
}
