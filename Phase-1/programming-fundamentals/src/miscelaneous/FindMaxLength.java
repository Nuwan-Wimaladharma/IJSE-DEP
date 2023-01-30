package miscelaneous;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] data = {"Nuwan Wimaladharma", "Gayashan Dhanajaya", "Vipula Neranjana", "Sagara Pradeep", "Hasitha Kaushan"};
        findTheLongest(data);
    }
    public static void findTheLongest(String[] data){
        int index = 0;
        String text = null;
        int length = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].length() > length){
                length = data[i].length();
                text = data[i];
                index = i;
            }
        }
        System.out.println("Max length string: " + text);
        System.out.println("Max index: " + index);
        System.out.println("Max length: " + length);
    }
}
