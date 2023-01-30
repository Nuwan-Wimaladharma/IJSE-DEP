package lk.ijse.dep10.oop;

public class AppInitializer {
    static int x = 10;
    public AppInitializer(){
        System.out.println("This is constructor"); //this won't run if there is no object created from AppInitializer() prints @ #6
    }
    static {
        System.out.println("x(static 1) = " + x); //legal //prints @ #1
        System.out.println("Static Initializer 1"); //prints @ #2
        //System.out.println(y); //illegal, because y hasn't been initialized yet(According to forward referencing rule)
    }
    public static void main(String[] args) {
        new AppInitializer(); //constructor will run, because this is the object created from AppInitializer class
        System.out.println("Inside the main method"); //prints third prints @ #7
        System.out.println("Just about to exit the main method"); //prints fourth prints @ #8
        System.out.println("x(main) = " + x); //prints @ #9
        System.out.println("y(main) = " + y); //prints @ #10
    }
    static int y = 20;
    static {
        System.out.println("x(static 2) = " + x); //prints @ #3
        System.out.println("y(static 2) = " + y); //prints @ #4
        System.out.println("static Initializer 2"); //prints second //prints @ #5
    }
}
