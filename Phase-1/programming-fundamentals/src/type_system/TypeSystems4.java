package type_system;

public class TypeSystems4 {
    public static void main(String[] args) {
        boolean myBoolean = false;
        byte myByte = 20;
        short myShort = 20;
        char myChar = 'A';
        int myInt = 40;
        long myLong = 50;
        float myFloat = 10;
        double myDouble = 20;

        String myString = myBoolean + ""; // concatenating an empty string to convert string
        System.out.println(myString);

        myString = myByte + "";
        System.out.println(myString);

        myString = myShort + "";
        System.out.println(myString);

        myString = myChar + "";
        System.out.println(myString);

        myString = new Float(myFloat).toString(); //another method in java 8
        System.out.println(myString);

        myString = new Double(myDouble).toString();
        System.out.println(myString);

        myString = Integer.toString(myInt); //another method in java 11
        System.out.println(myString);

    }
}
