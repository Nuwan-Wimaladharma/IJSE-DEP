package type_system;

public class TypeSystems3 {
    public static void main(String[] args) {
        boolean flag; //1 bit is enough from the RAM
        byte number1 = 127;
        byte number2 = -128;

        byte number3 = 15; //can assign a integer, because compiler confirms that assigned number is in the rage of byte

        int integerNumber = 15;
        // byte number4 = integerNumber;  // this can't be done, because value of integerNumber can be changed during the process and it can go beyond the range of byte data type

        final int constantInteger = 20;
        byte number5 = constantInteger; // this is possible because integer is constant and it is in the range of byte data type

        final int largeNumber = 300;
        // byte number6 = largeNumber; // this is impossible, because value of largeNumber is out of range of byte data type

        char character = 'A';
        character = 10;

        short number7 = 65;
        // character = number7; eventhough both data types take 16 bit, in short value is stored in 15 bits

        int number8 = character; //here, int take 32 bits and char takes 16 bits
    }
}
