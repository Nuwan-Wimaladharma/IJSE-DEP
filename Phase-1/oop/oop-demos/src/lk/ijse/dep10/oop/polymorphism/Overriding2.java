package lk.ijse.dep10.oop.polymorphism;

import org.w3c.dom.ls.LSOutput;

public class Overriding2 {
    public static void main(String[] args) {
        T t = new S();
        t.myMethod();
        t.myStaticMethod();
    }
}
class T{
    public static void myStaticMethod(){ //Hide
        System.out.println("T's static myMethod");
    }
    public void myMethod(){  //Override(non-static)
        System.out.println("T's myMethod");
    }
}
class S extends T{
    public static void myStaticMethod(){
        System.out.println("T's static myMethod");
    }
    public void myMethod(){
        System.out.println("S's myMethod");
    }
}
