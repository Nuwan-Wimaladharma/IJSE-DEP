package type_system;

public class TypeSystems9 {
    public static strictfp void main(String[] args) {
        float myFloat = 12; //this is ok
//        float myFloat2 = 45.321; //this isn't possible. because 45.321 is considered as a double. double cannot be assigned to a float
        float myFloat3 = 78.325f; //thus is ok

        float myFloat4 = 12.86598965658f;
        System.out.println(myFloat4); //gives 12.86599 as output

        double myDouble = myFloat4;
        System.out.println(myDouble); //gives 12.865989685058594 as output

        double result = 0.3 - 0.2;
        System.out.println(result); //gives 0.09999999999999998 as output. to get same value in every computers we have to use "strictfp" keyword in main method declaration

//        strictfp {
//            double result2 = 0.5 - 0.3;
//            System.out.println(result2); //not possible. strictfp context can be only used in methods, classes, enums, annotations
//        }

    }
}
