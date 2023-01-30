package miscelaneous;

public class StringFormatting {
    public static void main(String[] args) {
        int id = 5;
        //S001, S010, S120
        String studentId = String.format("S%03d", id);
        System.out.println(studentId);

        double value = 257253.125;
        String output = String.format("Rs.%,.2f", value);
        System.out.println(output);
    }
}
