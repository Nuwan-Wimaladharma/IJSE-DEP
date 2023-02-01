package lk.ijse.dep10.oop;

public class TemplateLoader {
    static {
        System.out.println("Template Loader Static Initialization");
    }
    //Methods to load the class file to the Heap
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Template Loader main()");
        //new myTemplate();
        System.out.println("=====================");
        //new myTemplate(); //once load the object class, no need to again oad the object class // Method #1
        System.out.println(myTemplate.y);
        //myTemplate.doSomething(); //Accessing a static method //Method #2
        //Class.forName("lk.ijse.dep10.oop.myTemplate"); //calling Class.forName() method //Method #2
    }
}

class myTemplate{
    int x = 10;
    static int y = 20;
    public myTemplate(){
        System.out.println("myTemplate constructor");
    }
    static {
        System.out.println("My Template Static Initialization");
    }

    public static void main(String[] args) {
        System.out.println("main() method myTemplate");
    }
    static void doSomething(){

    }

}
