package type_system;

public class TypeSystem2 {
    public static void main(String[] args) {
        var num1 = 10; //int
        var num2 = 20;  //int
        var flag = true;  //boolean
        var num3 = 19.25; //double
        var character = 'a'; //char
        var someString = "This is something";  //String

        num1 = 50;
        num2 = 70;
        flag = false;

        num1 = 80;

        final var interestRate = 9.6; // cannot change after finalization, but naming convention should be uppercase + snakecase & data type is double
        final var INTEREST_RATE = 9.6;

        character = 65; //a value can be assigned to a char variable (through encodeing system). All the character has a value

        System.out.println(character);


        int finalCount;
        finalCount = 5;

        String name = "IJSE";
        final double PI = 3.14;

        final int MARKS = 65 + 12; //this is a compile time constant

        final double RESULT = Math.random(); // this a run time constant

    }
}
