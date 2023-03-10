package lk.ijse.dep10.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    public static void main(String[] args) {
        String text = "Hi, my phone number is: 011-1234567. My home phone number is 055-4561237";
        text += "\n His phone number is: 071-2951059";

        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("Start = %d, End = %d \n",start,end);
            System.out.println(text.substring(start,end));
        }
        String replaceAllText = matcher.replaceAll("Ammo");
        System.out.println(replaceAllText);
    }
}
