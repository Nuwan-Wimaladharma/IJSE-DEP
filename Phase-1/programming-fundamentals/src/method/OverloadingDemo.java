package method;

import java.util.ArrayList;

public class OverloadingDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        numbers.remove(1);
    }
}
