package miscelaneous;

import java.util.Scanner;

public class StandardStreams2 {
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("Student Management System");
        System.out.println("------------------------");

        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter student name       : ");
        String name = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter your contact number: ");
        String phoneNumber = input2.next();

        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter your batch no      : ");
        int batchNo = input3.nextInt();

        //System.out.println("Welcome " + name + " " + phoneNumber + " " + "to batch " + batchNo);
        System.out.printf("Welcome %s (%s) to batch %s", name, phoneNumber, batchNo); //formatted print method
    }
}
