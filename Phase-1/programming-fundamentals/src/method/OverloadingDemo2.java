package method;

public class OverloadingDemo2 {
    public static void main(String[] args) {
        long x = 10;
        myMethod(x); //runs myMethod(int x) if integer accepting method exists
    }
    public static void myMethod(int x){
        System.out.println("myMethod(int)");
    }   //if this isn't exists, meMethod(long x) will run

//    public static void myMethod(long x){
//        System.out.println("myMethod(long)");
//    }
    public static void myMethod(float f){
        System.out.println("myMethod(float)");
    }
    public static void myMethod(double d){
        System.out.println("myMethod(double)");
    }
}
