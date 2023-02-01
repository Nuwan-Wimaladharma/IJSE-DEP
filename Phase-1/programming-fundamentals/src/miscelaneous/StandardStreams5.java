package miscelaneous;

import java.util.Scanner;

public class StandardStreams5 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter your marks(split via ','): ");
        String newInput = scanner.next();
        newInput += ",";
        int[] marksArray = new int[5];
        var scanner2 = new Scanner(newInput);
        scanner2.useDelimiter(",");

        marksArray[0] = Integer.parseInt(scanner2.next());   //marksArray[0] = scanner.nextInt();  (from sir)
        marksArray[1] = Integer.parseInt(scanner2.next());   //marksArray[1] = scanner.nextInt();
        marksArray[2] = Integer.parseInt(scanner2.next());   //marksArray[2] = scanner.nextInt();
        marksArray[3] = Integer.parseInt(scanner2.next());   //marksArray[3] = scanner.nextInt();
        marksArray[4] = Integer.parseInt(scanner2.next());   //scanner.useDelimiter(""); scanner.nextline(); marksArray[4] = scanner.nextInt();

        int totalMarks = marksArray[0] + marksArray[1] + marksArray[2] + marksArray[3] + marksArray[4];

        double averageMarks = (double) totalMarks / 5;
        System.out.println("Total marks = " + totalMarks);
        System.out.println("Average = " + averageMarks);

    }
}
