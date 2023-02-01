package operators;

public class Operators2 {
    public static void main(String[] args) {
        int result = 10 % 3;
        System.out.println(result);

        int a = 10;
        int b = 5;
        if (a++ < 5 && b++ > 2){ //if one statement becomes false other part won't check
            System.out.println("Ok");
        }
        System.out.println(a); //11
        System.out.println(b); //5 #because b++ > 2 statement won't check, because a++ < 5 already false.

        int c = 10;
        int d = 5;
        if (c++ < 5 & d++ > 2){ //even one statement becomes false other part also check
            System.out.println("Ok");
        }
        System.out.println(c); //11
        System.out.println(d); //6 #because b++ > 2 statement also check, because bitwise operator has been used

        int number = 20;
        String answer = number > 10 ? "ijse" : "something"; //ternary operation
        System.out.println(answer);
    }
}
