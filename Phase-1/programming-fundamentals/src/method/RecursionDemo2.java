package method;

public class RecursionDemo2 {
    public static void main(String[] args) {
        printStarsRectangle(8,4);
    }
    public static void printStarsRectangle(int length, int width){
        if (width > 0){
            System.out.println("* ".repeat(length));
            width--;
            printStarsRectangle(length,width);
        }
    }
}
