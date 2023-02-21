package lk.ijse.dep10.oop.polymorphism;

public class Polymorphism {
    public static void main(String[] args) {
        Car prius = new Prius();
        prius.advancedBreakingSystem(); //runs method in Prius class
        Car bugatti = new Bugatti();
        bugatti.advancedBreakingSystem();  //runs method in Bugatti class (Because, advancedBreakingSystem has been overridden)
        Car car1 = new Car();
        car1.advancedBreakingSystem();
//        Car myCar = prius;
//        System.out.println(myCar); //prius
//        myCar = bugatti;
//        System.out.println(myCar); //bugatti
//        System.out.println(prius);
//        System.out.println(myCar);
//        System.out.println(myCar == prius);
    }
}
class Vehicle{
    public void horn(){}
    public void accelerate(){}
    public void pushBreak(){}
}
class Car extends Vehicle{
    public void advancedBreakingSystem(){
        System.out.println("Car advanced breaking system");
    }
}
class Prius extends Car{
    public void hybrid(){}
    public void advancedBreakingSystem(){
        System.out.println("Prius advanced breaking system");
    }
}
class Bugatti extends Car{
    public void turboAcceleration(){}
    public void advancedBreakingSystem(){
        System.out.println("Bugatti advanced breaking system");
    }
}
