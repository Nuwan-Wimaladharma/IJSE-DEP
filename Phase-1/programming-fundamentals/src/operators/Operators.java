package operators;

public class Operators {
    public static void main(String[] args) {
        var a = 10;
        System.out.println(a++); //10
        System.out.println(a);  //11

        var b = 15;
        System.out.println(++b); //16
        System.out.println(b); //16

        var c = 5;
        System.out.println(c--); //5
        System.out.println(c); //4

        var d = 20;
        System.out.println(--d); //19
        System.out.println(d); //19

        var x = 5;
        System.out.println(~5); //convert 5 to its binary pattern and take the compliment of it

        var y = 15;
        System.out.println(~y + y++);

        var l = 8;
        var k = 4;
        System.out.println(l++ + ~k + ~l + k++);

        var a1 = 8;
        var b1 = 2;
        var c1 = 4;
        System.out.println(~a1 + b1 + c1++ + ~b1 + ++b + ~++a);
    }
}
