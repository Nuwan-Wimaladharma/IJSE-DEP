package lk.ijse.dep10.oop;

public class InstanceCreation {
    public static void main(String[] args) {
        Customer c001 = new Customer();
        System.out.println("===========");
        Customer c002 = new Customer();
        System.out.println(c001.address); //Panadura
        System.out.println(c002.address); //Panadura
        System.out.println(c001.name); //null
        System.out.println(c002.name); //null
        System.out.println(Customer.id); //0
        System.out.println(c001.id); //0
        c001.id = 3; // even though id isn't a local variable for Customer class, c001 instance has been linked to the created Customer class object and these changes affects for every instances created from that class
        System.out.println(c002.id); //3
        System.out.println(Customer.id); //3
        c001.name = "Kasun";
        System.out.println(c001.name);//Kasun
        System.out.println(c002.name); //null
    }
}

class Customer {
    static int id;
    static {
        System.out.println("Customer static initialization 1");
    }
    {
        System.out.println("Instance initializer 1"); //this is initializer, but not static
    }
    String name;
    public Customer(){
        //super(); //hidden , this is a method invocation  # this() keyword can be here, but default one is super() #after this line, instance variables and instance initializers starts to get initialized
        System.out.println("Constructor: Customer");
    }
    static {
        System.out.println("Customer static initialization 2");
    }
    String address = "Panadura";
    {
        System.out.println("Instance initializer 2");
    }
}
