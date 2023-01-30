package statement.demos;

public class StringDemo2 {
    public static void main(String[] args) {
        //java 11
        String star = "* ";
        System.out.println(star.repeat(5));

        //java 11
        String something = "              this is my contact            ";
        System.out.println(something.stripLeading()); //removes leading white spaces
        System.out.println(something.stripTrailing()); //removes lagging white spaces
        System.out.println(something.strip()); //just like trim(), but this is most suitable than trim()

        var name = "Kasun";
        var contact = "077-8004737";
        var age = 26;
        something = String.format("Hi my name is %s, My contact number is: %s, My age is: %s",name,contact,age);
        System.out.println(something);

        something = String.format("%1$s's Details, %1$s's contact: %2$s, %1$s's age = %3$s", name,contact,age);
        System.out.println(something);

        something = String.format("%50s", "Hello"); //%50s ---> creates a string with 50 white spaces (auto align to right("Hello")) ---> "                       Hello"
        System.out.println(something);

        something = String.format("%-50s", "Hello"); // (auto align to leff("Hello")) ---> "Hello                       "
        System.out.println(something);
    }
}
