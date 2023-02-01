package statement.demos;

import java.util.Scanner;

public class LoopDemo3 {
    public static void main(String[] args) {
        String[][] studentInfo = new String[3][3];
        var scanner = new Scanner(System.in);
        var customerIndex = 1;

        System.out.printf("Customer-%s details",customerIndex);
        System.out.println("------------------");

        while (true){
            var validCustomerId = false;
            System.out.print("Customer ID: ");
            var customerId = scanner.nextLine().trim();

            char[] chars = customerId.toCharArray();
            if (chars.length == 4 && chars[0] == 'C' && Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3])){
                validCustomerId = true;
            }
            if (validCustomerId == false){
                continue;
            }
            else {
                break;
            }
        }

    }
}
