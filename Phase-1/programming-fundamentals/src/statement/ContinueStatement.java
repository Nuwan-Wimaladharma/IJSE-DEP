package statement;

public class ContinueStatement {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++){
//            System.out.println("------------");
//            System.out.println(i + " IJSE");
//            if (i == 3){
//                continue;
//            }
//            System.out.println(i + " ABC");
//
//        }
        label1:
        System.out.println("Nested Loops");

        forLoop:
        for (int i = 0; i < 5; i++) {
            System.out.println("For Loop: Iteration start ---> i = " + i);
            int k = 0;

            whileLoop: //label statements
            while (k++ < 3){
                if (k == 3) continue forLoop; //skips to the next iteration of the for loop
                System.out.println("While loop: iteration start ---> k = "+ k);
                System.out.println("While loop: iteration ends ---> k = "+ k);
            }
            //if (true) continue forLoop;
            System.out.println("For loop: Iteration end ---> i = " + i);
            System.out.println();
        }
    }
}
