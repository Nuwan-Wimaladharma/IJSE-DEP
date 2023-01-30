public class Loop1 {
    public static void main(String[] args) {
//        for (; true;) { //infinite loop
//            System.out.println("IJSE");
//            System.out.println("----");
//            System.out.println("DEP-10");
//            System.out.println();
//        }

        for (int i = 0; i <= 10; i++) {
            System.out.println("IJSE");
            System.out.println("----");
            System.out.println("DEP-10");
            System.out.println();
        }


        boolean flag = true;

        for (int x = 0; flag; x++ ){
            System.out.println("Nuwan");
            System.out.println("Wimaladharma");
            System.out.println();
            x++;
            if (x == 5) flag = false;
        }

        for (int x = 0; x < 5; x++){
            System.out.println("Nuwan");
            System.out.println("Wimaladharma");
            System.out.println();
        }
    }
}
