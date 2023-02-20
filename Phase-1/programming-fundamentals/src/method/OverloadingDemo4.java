package method;

public class OverloadingDemo4 {
    public static void main(String[] args) {
        byte x = 10;
        short y = 20;
        int z = 30;
        float f = 10.0f;
        //myMethod(x,y,z,f);
    }

//    public static void myMethod(short x, Short y, Integer z, float d){
//        System.out.println("myMethod(short, Short, int, float)");
//    }

    public static void myMethod(Short x, float y, float z, float d){
        System.out.println("myMethod(short, float, float, float)");
    }

    public static void myMethod(int x, float y, Double z, float d){
        System.out.println("myMethod(int, float, double, float)");
    }

    public static void myMethod(short x, Float y, double z, float d){
        System.out.println("myMethod(short, float, double, float)");
    }

//    public static void myMethod(short x, Short y, int z, float d){
//        System.out.println("myMethod(short, Short, int, float)");
//    }
}
