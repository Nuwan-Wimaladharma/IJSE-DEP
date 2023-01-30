package miscelaneous;

import java.util.Scanner;

public class StandardStreams3 {
    public static strictfp void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter your name               : ");
        String name =input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the marks for pf        : ");
        int marksForPf =input1.nextInt();

        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter the marks for dbms      : ");
        int marksForDbms =input1.nextInt();

        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter the marks for oop       : ");
        int marksForOop =input1.nextInt();

        Scanner input5 = new Scanner(System.in);
        System.out.print("Enter the marks for networking: ");
        int marksForNetworking =input1.nextInt();

        int totalMarks = marksForPf + marksForDbms + marksForOop + marksForNetworking;
        double averageMarks = (double) totalMarks / 4;

        System.out.println(name + "'s total marks: " + totalMarks);
        System.out.println(name + "'s Avg : " + averageMarks);
    }
}
