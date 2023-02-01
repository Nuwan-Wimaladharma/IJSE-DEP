package method;

public class RecursionDemo1 {
    public static void main(String[] args) {
        //printStars(6);
        //starPatternDecrease(6);
        starPatternIncrease(1);
    }

    public static void printStars(int iterations){
        if (iterations > 0){
            System.out.println("* ".repeat(6));
            printStars(--iterations);
        }
    }
    public static void starPatternDecrease(int iterations){
        if (iterations > 0){
            System.out.println("* ".repeat(iterations));
            starPatternDecrease(--iterations);
        }
    }
    public static void starPatternIncrease(int iterations){
        if (iterations < 6){
            System.out.println("* ".repeat(iterations));
            starPatternIncrease(++iterations);
        }
    }

}
