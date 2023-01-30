package statement.demos;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
//        var scanner = new Scanner(System.in);
//        System.out.print("Enter something: ");
//        var something = scanner.nextLine();
//
//        System.out.printf("Inputted text: %s \n", something);
//        System.out.printf("Inputted text to string is : %s \n", something.toString()); //these two Souts are equal
//        System.out.printf("Length of the text is : %s \n", something.length());
//        System.out.printf("Selected char from inputted text is: %s \n", something.charAt(0));
//        System.out.printf("Upper case & lower case : %s \n", something.toUpperCase());
//        System.out.printf("Trim method: %s \n", something.trim()); //removes leading and following white spaces in the string "   Nuwan   " ------> "Nuwan"

        var a = "Nuwan";
        var b = a.toUpperCase();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b); //return false #strings are immutable. if we do something to a string, changes are not applied to the current string. its created a new string #new variable created in in string pool not in the constant string pool
        var something = " ";
        System.out.println("isBlank ? " + something.isBlank()); //if there is only white spaces in the string
        System.out.println("isEmpty ? " + something.isEmpty()); //if there is space in the string, this consider as not empty

//        String something2 = null;
//        System.out.println("isBlank ? " + something2.isBlank()); //thrown a NullPointerExeption. because no objects created in the heap when created null
//        System.out.println("isEmpty ? " + something2.isEmpty());

        // Substrings


        var something3 = "Hi! we are DEP-10";
        String extracted1 = something3.substring(4);
        String extracted2 = something3.substring(7, 10);
        System.out.println(extracted1);
        System.out.println(extracted2);

        //splitting a string

        var something4 = "Monday,     Tuesday, Wednesday         ,  Thursday,          Friday        , Saturday,    Sunday";
        String[] splits = something4.split(",");
        System.out.println(splits[0] = splits[0].trim()); //assign the trimmed string to the splits[0]
        System.out.println(splits[1].trim()); //no assign the trimmed string to the splits[1], just prints. if we print splits[1] again, it will return the string with white spaces
        System.out.println(splits[2].trim());
        System.out.println(splits[3].trim());
        System.out.println(splits[4].trim());
        System.out.println(splits[5].trim());
        System.out.println(splits[6].trim());

        //contain method

        System.out.println(something4.toLowerCase().contains("tuesday")); //true

        //index of method

        System.out.println(something4.toLowerCase().indexOf("day"));

        //lastindexof method

        System.out.println(something4.toLowerCase().lastIndexOf("y")); //returns the last index where inputted character exist

        var something5 = "We are from DEP-10. We are born to code! We like codes";
        System.out.println(something5.indexOf("from"));
        System.out.println(something5.lastIndexOf("from"));

        //replace method

        String newtext = something5.replaceAll("We", "They");
        System.out.println(newtext);
    }
}
