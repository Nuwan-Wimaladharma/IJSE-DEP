package lk.ijse.dep10.oop;

public class Shadowing { //outer scope
    static int x = 10;
    //int x = 20; //not allowed. static and non-static identifiers with same name cannot be here
    public Shadowing(int x){
        //String x = "IJSE"; //cannot be repeated identifiers in same class
    }
    public static void main(String[] args) { //inner scope
        String x = "Nuwan";
        System.out.println(x); //inside the inner scope, x in the outer scope is affected the shadow of x in inner scope (data type won't affect, only the identifier)
        System.out.println(Shadowing.x); //if we able to refer the outer scope, we can access the identifier in outer scope
        {
            //String x = "Something"; not allowed, because there cannot be same identifier in the stack
        }
    }
}
