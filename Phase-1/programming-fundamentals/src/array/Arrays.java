package array;

public class Arrays {
    public static void main(String[] args) {
        int[] myArray = {10, 20, 30}; //array is an object and reference data type
        System.out.println(myArray); //prints [I@6debcae2. prints the location of the myArray in the memory
        System.out.println(myArray.length); // Dot notation go inside the created array
        System.out.println(myArray[0]); //access to the array elements using array index

        String[] myStringArray = {"Kasun", "Nuwan", "Sagara"};
        System.out.println(myStringArray[2]);

        myArray = null;
        myStringArray = null;

        System.out.println(myArray); // null is not primitive or reference data type. it is data type in between primitive and reference. But we cannot create variables usng null
        System.out.println(myStringArray);

        String something = "IJSE";
        something = null;
        System.out.println(something);
    }
}
