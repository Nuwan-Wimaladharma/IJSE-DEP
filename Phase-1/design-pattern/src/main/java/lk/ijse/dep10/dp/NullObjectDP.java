package lk.ijse.dep10.dp;

import java.util.Optional;

public class NullObjectDP {
    public static void main(String[] args) {
//        System.out.println(extract1("IJSE",1, 2).toUpperCase());
//        System.out.println(extract1("Something",-2,3).toUpperCase());
//        System.out.println(extract1("Here is some text", 5, 3).toUpperCase());
//        System.out.println(extract1("Here is some text",3,7).toUpperCase());

        System.out.println(extract2("IJSE",1, 2).orElse("Invalid Extraction").toUpperCase());
        System.out.println(extract2("Something",-2,3).orElse("Invalid Extraction").toUpperCase());
        System.out.println(extract2("Here is some text", 5, 3).orElse("Invalid Extraction").toUpperCase());
        System.out.println(extract2("Here is some text",3,7).orElse("Invalid Extraction").toUpperCase());
    }
//    public static void print(String extractedText){
//        System.out.println(extractedText != null? extractedText.toUpperCase(): "Invalid extraction");
//    }
    public static String extract1(String input, int start, int end){
        if (start < 0 || end > input.length()) return null;
        String extractedText = input.substring(start, end);
        return extractedText;
    }
    public static Optional<String> extract2(String input, int start, int end){
        if (start < 0 || end > input.length()) return Optional.empty();
        String extractedText = input.substring(start, end);
        return Optional.of(extractedText);
    }
}
