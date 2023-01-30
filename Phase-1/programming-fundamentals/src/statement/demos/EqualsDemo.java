package statement.demos;

public class EqualsDemo {

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public static void main(String[] args) {
        String str1 = "IJSE";
        String str2 = new String("IJSE");
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true

        var demo1 = new EqualsDemo();
        var demo2 = new EqualsDemo();
        System.out.println(demo1 == demo2); //false
        System.out.println(demo1.equals(demo2)); //false # if return true from override method, this returns true
    }

}
