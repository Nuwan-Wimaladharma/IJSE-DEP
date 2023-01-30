public class UnicodeInJava {
    public static void main(String[] args) {
        System.out.println("Let's use an emoji: \uD83C\uDF93");
        System.out.println("Let's use an emoji: U+1F402"); // (\ u_____) space should be a hexadecimal number (syntax of a unicode in java)

        System.out.println("\u0041");  //prints "A"

        System.out.println((int) 's'); //unicode value of 's' is 115
        System.out.println("\u0073"); //hexadecimal of 115 is 73
    }
}
