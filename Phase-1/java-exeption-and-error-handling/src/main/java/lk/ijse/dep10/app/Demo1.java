package lk.ijse.dep10.app;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(10 / 0);
//        int x = Integer.parseInt("abc");
//        System.out.println(x);

//        String something = null;
//        System.out.println(something.length());

//        Class.forName("abc");
        myMethod1();

    }
    public static void myMethod1(){
        System.out.println("Before myMethod2 Innovaction");
        myMethod2();
        System.out.println("After myMethod2 Innovaction");
    }
    public static void myMethod2(){
        try {
            System.out.println("Let's try this");
            Class.forName("abc");
            System.out.println("Hooray");
        } catch (Throwable t) { //use Throwable/Exception/ClassNotFount, but cannot use Error since it is a unchecked exeption
            System.out.println(t);
        }
    }
}
