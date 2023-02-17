package type_system;

public class BoxingVsUnboxing {
    public static void main(String[] args) {
        Integer myInt = new Integer(10);
        int x = 10;
        myInt = new Integer(x); //boxing

        Integer myInt2 = 20; // automatically wrapping like ---> new Integer(20) ---> this is auto boxing

        int y = myInt2.intValue(); //unboxing
        int z = myInt2; //myInt2.intValue() --> auto unboxing
    }
}
