package statement;

public class BreakStatement3 {
    public static void main(String[] args) {
        start:
        System.out.println("App started");

        first:{
            System.out.println("First started");
            second:{
                System.out.println("Second started");
                third:{
                    System.out.println("Third started");
                    forth:{
                        System.out.println("Fourth started");
                        if (true) break third;
                        System.out.println("Fourth ends");
                    }
                    System.out.println("Third ends");
                }
                System.out.println("Second ends");
            }
            System.out.println("First ends");
        }
        end:
        System.out.println("App ended");
    }
}
