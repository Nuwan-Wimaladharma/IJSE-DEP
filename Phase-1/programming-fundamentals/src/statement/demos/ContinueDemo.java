package statement.demos;

import java.util.Scanner;

public class ContinueDemo {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Input a phone number (Format: 07X-XXXXXXX): ");
        String contact = scanner.nextLine();
        if (contact.length() != 11 || contact.charAt(3) != '-'){
            System.out.println("Invalid Contact Number");
        }
        else {
            char[] contactArray = contact.toCharArray();
            boolean validContact = true;
            for (int i = 0; i < contactArray.length; i++) { //press (alt + enter) on the loop and switch between loop types
                if (i == 3)continue;
                char c = contactArray[i];
                validContact = validContact && Character.isDigit(c);
            }
            if (validContact){
                System.out.println("Valid Contact");
            }
            else {
                System.out.println("Invalid Contact Number");
            }
        }
    }
}
