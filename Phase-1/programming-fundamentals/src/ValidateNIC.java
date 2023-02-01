import java.util.Scanner;

public class ValidateNIC {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a NIC: ");
        var nic = scanner.nextLine();
        if (nic.isBlank()){
            System.err.println("Invalid");
        }
        nic = nic.trim();
        if (nic.length() != 10){
            System.err.println("Invalid NIC");
        }
        char[] chars = nic.toCharArray();
        boolean valid = true;
        for (int i = 0; i < chars.length-1; i++) {
            Character.isDigit(chars[i]);
        }
    }
}
