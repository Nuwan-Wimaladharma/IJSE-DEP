package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String nic;
            do {
                System.out.print("Enter a contact: ");
                nic = scanner.nextLine();
            }while (nic.isBlank());
            System.out.println(isValidContact(nic.strip()));
        }
    }
    private static boolean isValidContact(String input){
        return input.matches("([+](94)|0)\\d{2}-\\d{7}");
//        if (input.length() != 11 && input.length() != 13) return false;
//        if (!input.startsWith("0") && !input.startsWith("+94")) return false;
//        if (input.startsWith("0")){
//            char[] chars = input.toCharArray();
//            if (chars[3] != '-') return false;
//            for (int i = 1; i < input.length(); i++) {
//                if (i == 3) continue;
//                if (!Character.isDigit(chars[i])){
//                    return false;
//                }
//            }
//        }
//        if (input.startsWith("+94")){
//            char[] chars = input.toCharArray();
//            if (chars[5] != '-') return false;
//            for (int i = 3; i < input.length(); i++) {
//                if (i == 5) continue;
//                if (!Character.isDigit(chars[i])){
//                    return false;
//                }
//            }
//        }
//        return true;
    }
}
