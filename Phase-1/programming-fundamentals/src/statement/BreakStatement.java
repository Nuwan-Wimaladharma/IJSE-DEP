package statement;

public class BreakStatement {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration starts "+ i);
            if (i == 2){
                break;
            }
            System.out.println("Iteration ends " + i);
        }
        System.out.println("End of loop");
    }
}
