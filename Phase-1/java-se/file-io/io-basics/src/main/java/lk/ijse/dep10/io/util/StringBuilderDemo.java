package lk.ijse.dep10.io.util;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Kasun")
                .append("wants")
                .append("something")
                .insert(5," ")
                .insert(11," ")
                .append(".")
                .setCharAt(0,'k');
        System.out.println(sb.toString());


        StringBuffer sb1 = new StringBuffer();  //StringBuffer is old one. This is thread safe. but performance is lower than string builder
        sb1.append("Kasun")
                .append("wants")
                .append("something")
                .insert(5," ")
                .insert(11," ")
                .append(".")
                .setCharAt(0,'k');
        System.out.println(sb1.toString());
    }
}
