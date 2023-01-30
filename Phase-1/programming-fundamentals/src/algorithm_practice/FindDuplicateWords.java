package algorithm_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicateWords {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter something you want: ");
        String input = scanner.nextLine().trim();
        CLITable.printTable(new String[]{"Word","Count"},findDuplicateWords(input));
    }
    public static String[][] findDuplicateWords(String inputString){
        String[] words = inputString.split(" ");
        ArrayList newWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals("") || word.equals(".") || word.equals(",")) continue;
            else {
                if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ',' || word.charAt(word.length()-1) == ' '){
                    String newWord = word.substring(0,(word.length()-1));
                    newWords.add(newWord);
                }
                else {
                    newWords.add(word);
                }
            }
        }
        ArrayList duplicateWords = new ArrayList<>();
        ArrayList wordCount = new ArrayList<>();
        for (int i = 0; i < newWords.size(); i++) {
            int count = 1;
            for (int j = 0; j < newWords.size(); j++) {
                if (i == j) continue;
                else {
                    if (newWords.get(i).equals(newWords.get(j))){
                        count += 1;
                    }
                }
            }
            if (count > 1 && !duplicateWords.contains(newWords.get(i))){
                duplicateWords.add(newWords.get(i));
                wordCount.add(count);
            }
        }
        String[][] wordsAndCount = new String[duplicateWords.size()][2];
        for (int i = 0; i < wordsAndCount.length; i++) {
            wordsAndCount[i][0] = duplicateWords.get(i).toString();
            wordsAndCount[i][1] = wordCount.get(i).toString();
        }
        return wordsAndCount;
    }
}

