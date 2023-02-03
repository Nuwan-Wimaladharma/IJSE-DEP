package lk.ijse.dep10.oop;

public class Inheritance {
    public static void main(String[] args) {
        Car car = new Car();
        //System.out.println("End...........");
        //Van van = new Van();
    }
}
class Vehicle{
    String registrationNumber;
    static {
        System.out.println("Vehicle class is being initialized");
    }
    {
        System.out.println("Vehicle object is being initialized");
    }
    void printRegistrationNumber(){
        System.out.println(registrationNumber);
    }
    public Vehicle(){
        System.out.println("Vehicle constructor");
    }

}
class Car extends Vehicle{ //Relationship is ----> Car is a Vehicle
    static {
        System.out.println("Car class is being initialized");
    }
    {
        System.out.println("Car object is being initialized");
    }
    public Car(){
        System.out.println("Car constructor");
    }
}
class Van extends Vehicle{ //Van is a Vehicle
    static {
        System.out.println("Van class is being initialized");
    }
    {
        System.out.println("Van object is being initialized");
    }
    public Van(){
        System.out.println("Van constructor");
    }
}
