package method;

public class OverloadingDemo3 {
    public static void main(String[] args) {
        byte b = 10;
        short s = 15;
        float f = 10.0f;
        //myMethod(b,s,f);
    }
    public static void myMethod(int x, short y, double z){
        System.out.println("myMethod(int,short,double)");
    }

    public static void myMethod(long x, int y, float f){
        System.out.println("myMethod(int,long)");
    }

    public static void myMethod(short x,int y, double d){
        System.out.println("myMethod(short,int,double)");
    }

    public static void myMethod(int x, long y, double d){
        System.out.println("myMethod(int,long,double)");
    }

}
