package statement;

public class DoStatement {
    public static void main(String[] args) {
//        boolean flag = false;
//        while (flag){
//            System.out.println("IJSE");
//        }
//
//        do {
//            System.out.println("IJSE");
//        } while (flag);   //there is atleast one iteration is executed


//        int x = 0;
//        while (x++ < 6){
//            System.out.println("* * * * * *");
//        }
//        System.out.println("======================");
//        x = 0;
//        do {
//            System.out.println("* * * * * *");
//        } while (x++ < 6);

        int x = 0;
        while (x < 6){
            System.out.println("* * * * * *");
            x++;
        }
        System.out.println("======================");
        x = 0;
        do {
            System.out.println("* * * * * *");
            x++;
        } while (x < 6);


    }
}
