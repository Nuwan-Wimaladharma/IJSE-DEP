public class Conversions {
    public static void main(String[] args) {
        boolean flag1 = true;
        boolean flag2 = flag1; //identity conversion ----> data conversion is occurred between same data type

        int int1 = 10;
        int int2 = int1;        //identity conversion

        double d1 = 10.2;
        double d2 = d1;         //identity conversion

        char c1 = 'a';
        char c2 = c1;           //identity conversion

        String str1 = "IJSE";
        String str2 = str1;     //identity conversion

        byte myByte = 10;       //narrowing conversion
        short myShort = 10;     //narrowing conversion
        int myInt = 10;         //identity conversion
        long myLong = 10;       // widening conversion
        float myFloat = 10;     //widening conversion
        double myDouble = 10;   //widening conversion
        myDouble = myLong;      //widening conversion
        myDouble = myInt;       //widening conversion
        myFloat = myLong;       //widening conversion
        char myChar = 'a';
        myInt = myChar;         //widening conversion
        myLong = myChar;        //widening conversion
        myDouble = myChar;      //widening conversion
        myFloat = myChar;       // widening conversion

        double num1 = 0.3;
        double num2 = 0.2;
        double result = num1 - num2;
        System.out.println(result); // answer is 0.09999999999999998. don't use double data type if you need exact values

        int myInt2 = 500;
        byte myByte2 = (byte) myInt2; //casting
        System.out.println(myByte2);
    }
}
