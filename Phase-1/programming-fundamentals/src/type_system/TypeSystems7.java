package type_system;

public class TypeSystems7 {
    public static void main(String[] args) {
        String myStr = "true";
        boolean myBool = new Boolean(myStr); //Java 8
        System.out.println(myBool);
        myBool = Boolean.valueOf(myStr); //Java11
        System.out.println(myBool);

        myStr = "10";
        byte myByte = new Byte(myStr); // Java 8
        System.out.println(myByte);
        myByte = Byte.valueOf(myStr);// Java 11
        System.out.println(myByte);

        short myShort = new Short(myStr); //Java 8
        System.out.println(myShort);
        myShort = Short.valueOf(myStr); //Java 11
        System.out.println(myShort);

        myStr = "ijse";
//        char myChar = Character.valueOf(myStr); //not suit for char
//        char myChar = new Character(myStr);

        char myChar = myStr.charAt(0);
        System.out.println(myChar);
    }
}