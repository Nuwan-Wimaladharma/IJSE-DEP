package lk.ijse.dep10.oop;

public class Overloading2 {
    public static void main(String[] args) {
        B.myMethod(10);
        B.myMethod("Nuwan");
        new B().myMethod("Nuwan",25);
    }
}
class A {
    public static void myMethod(String something){ //method overloading can be occurred in same class hierarchy. Should not in the same class
        System.out.println("myMethod(String)");
    }
    public static void myMethod(int something){
        System.out.println("myMethod(int)");
    }
    public void myMethod(String something, int x){ //this is also overloaded method, even though it is a non-static method. Only considering thing is method signature
        System.out.println("myMethod(String,int)");
    }
}
class B extends A{
    public static void myMethod(long something){
        System.out.println("myMethod(long)");
    }
}
