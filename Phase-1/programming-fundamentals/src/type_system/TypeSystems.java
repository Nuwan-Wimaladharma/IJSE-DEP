package type_system;

public class TypeSystems {
    public static void main(String[] args) {
        System.out.println(true);
        System.out.println(false);

        System.out.println(0b111); //binary
        System.out.println(0B111); //binary

        System.out.println(010); //octal
        System.out.println(7); //decimal

        System.out.println(0x11); //hexadecimal
        System.out.println(0xA);
        System.out.println(0xB);
        System.out.println(0Xc);
        System.out.println(0xD);
        System.out.println(0xe);

        System.out.println(12.25);
        System.out.println(012.25);
//        System.out.println(0x12.34);

        System.out.println(12.25e2);
        System.out.println(12.25e-2);

        System.out.println('a');
        System.out.println("Nuwan");
        System.out.println(0x1p-3);

        System.out.println(789098888856l); //long number representation by adding 'l' or 'L' at the end
        System.out.println(6789767867655676558l);
    }
}
