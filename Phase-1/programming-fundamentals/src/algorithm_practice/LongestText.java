package algorithm_practice;

public class LongestText {
    public static void main(String[] args) {
        String[] text = new String[]{"Nuwan", "Vipula","Gayashan", "Thusitha","Janitha", "Sagara", "Mithila", "My scool was Ananda College","Wimaladharma","Samaradiwakara"};
        //System.out.println("Longest text is: " + LongestTextForLoop(text));
        //System.out.println("Longest text is: " + LongestTextWhileLoop(text));
        //System.out.println("Longest text is: " + LongestTextDoWhileLoop(text));
        //System.out.println("Longest text is: " + LongestTextForEachLoop(text));
        LongestTextRecursion(text, text.length,0,0);
    }
    public static String LongestTextForLoop(String[] array){
        int length = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > length){
                length = array[i].length();
                index = i;
            }
        }
        return array[index];
    }
    public static String LongestTextWhileLoop(String[] array){
        int length = 0;
        int index = 0;
        int i = 0;
        while (i < array.length){
            if (array[i].length() > length){
                length = array[i].length();
                index = i;
            }
            i++;
        }
        return array[index];
    }
    public static String LongestTextDoWhileLoop(String[] array){
        int length = 0;
        int index = 0;
        int i = 0;
        do {
            if (array[i].length() > length){
                length = array[i].length();
                index = i;
            }
            i++;
        }while (i < array.length);
        return array[index];
    }
    public static String LongestTextForEachLoop(String[] array){
        int length = 0;
        int index = 0;
        int i = 0;
        for (String words : array){
            if (words.length() > length){
                length = words.length();
                index = i;
            }
            i++;
        }
        return array[index];
    }
    public static void LongestTextRecursion(String[] array, int arrayLength, int initialLength, int initialIndex){
        if (arrayLength-1 >= 0){
            if (array[arrayLength-1].length() > initialLength){
                initialLength = array[arrayLength-1].length();
                initialIndex = arrayLength-1;
                LongestTextRecursion(array,--arrayLength, initialLength,initialIndex);
            }
            else {
                LongestTextRecursion(array,--arrayLength, initialLength,initialIndex);
            }
        }
        else {
            System.out.println("Longest text is: " + array[initialIndex]);
        }
    }
}
