package statement;

import java.util.Scanner;

public class IfStatement2 {
    public static void main(String[] args) {
        var scanner1 = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner1.nextLine();

        var scanner2 = new Scanner(System.in);
        System.out.print("Enter student age: ");
        int age = scanner2.nextInt();

        if (age <= 18) System.out.println("Invalid age");
        else if (age > 40) System.out.println("Invalid age");
        else if (age > 18) System.out.println("Successfully added " + name);
    }
}
