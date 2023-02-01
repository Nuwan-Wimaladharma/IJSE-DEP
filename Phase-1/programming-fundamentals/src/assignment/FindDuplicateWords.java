package assignment;

import java.util.Arrays;

public class FindDuplicateWords {
    public static void main(String[] args) {
        String input = "Something is weired here something is crazy here";
        String input2 = "Nuwan Wimaladharma";
        findDuplicateWords(input);
    }
    public static void findDuplicateWords(String text){
        String[] words = text.split(" ");
        String duplicateWords = "";
        String duplicateWordCount = "";
        for (int i = 0; i < words.length; i++) {
            int count = 1;
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                else {
                    if (words[i].toUpperCase().equals(words[j].toUpperCase())){
                        count += 1;
                    }
                }
            }
            if (count > 1 && !duplicateWords.contains(words[i].toUpperCase())){
                duplicateWords += (words[i].toUpperCase() + " ");
                duplicateWordCount += (count + " ");
            }
        }
        String[] duplicates = duplicateWords.split(" ");
        String[] count = duplicateWordCount.split(" ");
        if (duplicates.length == 1){
            System.out.println("No duplicates here");
        }
        else {
            for (int i = 0; i < duplicates.length; i++) {
                System.out.println(duplicates[i] + " ---> " + count[i]);
            }
        }
    }
}
