import java.util.Scanner;

public class Loop2 {
    public static void main(String[] args) {
//        int x = 0;
//        while (x < 5);
//        System.out.println("IJSE"); //this is an unreachable statement. But thus cannot detect by the compiler.

//        while (x < 5); System.out.println(); //still an unreachable statement

//        while (x < 5){
//            System.out.println("Nuwan Wimaladharma");  //if you need to add a loop to a code segment ---> goto code ----> surround with -----> select appropriate one //shortcut -ctrl + alt + ','
//            x++;
//        }

        String [][] customerDetails = new String[3][3]; //to collapse a while loop -----> ctrl + '-' //opposite is ctrl + '+'
        int j = 0;
        while (j < 3){
            System.out.println("Enter customer " + (j+1) + " details"); //validName =customerName.matches(Z-Aa-z ); //using regular expressions
            String cusID = "";
            while (true){
                var scanner1 = new Scanner(System.in);
                System.out.print("Enter customer ID: ");
                boolean validId = false;
                String id = scanner1.nextLine().trim();
                char[] idChars = id.toCharArray();
                if (idChars.length == 4 && idChars[0] == 'C' && Character.isDigit(idChars[1]) && Character.isDigit(idChars[2]) && Character.isDigit(idChars[3])){
                    validId = true;
                    cusID = id;
                }
                if (validId == false){
                    System.out.println("Invalid ID");
                    continue;
                }
                else {
                    break;
                }

            }
            String cusName = "";
            while (true){
                var scanner2 = new Scanner(System.in);
                System.out.print("Enter customer name: ");
                boolean validName = false;
                String name = scanner2.nextLine().trim();
                char[] nameChars = name.toCharArray();
                int checkName = 0;
                int i = 0;
                while (i < nameChars.length){
                    if (nameChars[i] == ' '){
                        i++;
                        continue;
                    }
                    else {
                        if (!Character.isLetter(nameChars[i])){
                            checkName += 1;
                        }
                    }
                    i++;
                }
                if (nameChars.length > 3 && checkName == 0){
                    validName = true;
                    cusName = name;
                }
                if (validName == false){
                    System.out.println("Invalid Name");
                    continue;
                }
                else {
                    break;
                }
            }
            String cusPhoneNumber = "";
            while (true){
                var scanner3 = new Scanner(System.in);
                System.out.print("Enter customer phone number (07X-XXXXXXX): ");
                boolean validNumber = false;
                String phoneNumber = scanner3.nextLine().trim();
                char[] numberChars = phoneNumber.toCharArray();
                int checkNumber = 0;
                int i = 0;
                while (i < numberChars.length){
                    if (numberChars[i] == '-'){
                        i++;
                        continue;
                    }
                    else {
                        if (Character.isDigit(numberChars[i])){
                            checkNumber += 1;
                        }
                    }
                    i++;
                }
                if (numberChars.length == 11 && checkNumber == 10){
                    validNumber = true;
                    cusPhoneNumber = phoneNumber;
                }
                if (validNumber == false){
                    System.out.println("Invalid Number");
                    continue;
                }
                else {
                    break;
                }
            }
            customerDetails[j][0] = cusID;
            customerDetails[j][1] = cusName;
            customerDetails[j][2] = cusPhoneNumber;
            j++;
            System.out.println();
        }

        System.out.println("+-------------+-----------------------------+-----------------------+");
        System.out.println("| Customer ID |        Customer Name        | Customer Phone Number |");
        System.out.println("+-------------+-----------------------------+-----------------------+");
        int x = 0;
        while (x < 3){
            System.out.print("|" + customerDetails[x][0]);
            System.out.print("         |" + customerDetails[x][1] + " ".repeat(29-customerDetails[x][1].length()));
            System.out.print("|" + customerDetails[x][2] + "            |");
            System.out.println();
            System.out.println("+-------------+-----------------------------+-----------------------+");
            x++;
        }
    }
}
