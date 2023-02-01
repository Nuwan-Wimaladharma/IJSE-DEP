package assignment;

public class FindPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(4565));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(232));
        System.out.println(isPalindrome(1256));
        System.out.println(isPalindrome(125521));
    }
    public static boolean isPalindrome(int number){
        boolean isPalindromeNumber = false;
        int number2 = number;
        int fullPart = 0;
        int count = 1;
        while (number2 > 10){
            fullPart = number2 / 10;
            count += 1;
            number2 = fullPart;
        }
        int[] numbers = new int[count];
        int number3 = number;
        int remainder = 0;
        int wholePart = 0;
        int i = 0;
        while (i < count){
            wholePart = number3 / 10;
            remainder = number3 % 10;
            number3 = wholePart;
            numbers[i] = remainder;
            i++;
        }
        int newNumber = 0;
        for (int j = count; j > 0; j--){
            newNumber = (int) (newNumber + (Math.pow(10,(j-1)) * numbers[count - j]));
        }
        if (number == newNumber){
            isPalindromeNumber = true;
        }
        return isPalindromeNumber;
    }
}
