package statement;

public class Assertion {
    public static void main(String[] args) {
//        assert 5 > 1; //if this boolean expression becomes false, rest of program won't run. But, by default this has been disabled. This is use for testing purposes
        int x = 10;
        int result= x + 15;
        assert  result == 20;
        System.out.println("Continue...?");
    }
}
