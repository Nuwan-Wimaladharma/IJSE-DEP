package miscelaneous;

public class TableDemo {
    public static void main(String[] args) {
        String[] columnNames = {"ID", "Name","Phone"};
        String[][] data =
                {
                        {"S001", "Kasun", "011-1234567"},
                        {"S002", "Nuwan Wimaladharma", "077-1234567"},
                        {"S003", "Ruwan", "071-1234567"},
                        {"S004", "Supun", "076-1234567"},
                        {"S005", "Nimal", "072-1234567"}
                };
        printTable(columnNames,data);
    }
    public static void printTable(String[] columnNames, String[][] data){
        int[] columnsMaxLength = getColumnsMaxLength(columnNames.length,data);
        String record = "|";
        String border = "+";
        for (int i = 0; i < columnNames.length; i++) {
            int maxLength = columnsMaxLength[i];
            if (columnNames[i].length() > maxLength){
                maxLength = columnNames[i].length();
            }
            border += "-".repeat(maxLength).concat("+");
            record += "%-" + maxLength + "s|";
        }
        System.out.println(border);
        System.out.println(String.format(record,columnNames));
        System.out.println(border);
        for (String[] row : data){
            System.out.println(String.format(record,row));
        }
        System.out.println(border);
    }
    public static int[] getColumnsMaxLength(int columnCount, String[][] data){
        int[] maxLengths = new int[columnCount];
        for (int col = 0; col < columnCount; col++) {
            int maxLength = data[0][col].length();
            for (int row = 1; row < data.length; row++) {
                if (maxLength < data[row][col].length()){
                    maxLength = data[row][col].length();
                }
            }
            maxLengths[col] = maxLength + 1;
        }
        return maxLengths;
    }




//    public static int[] findNumberOfColumn(String[][] data){
//        int[] numberOfColumns = new int[data.length];
//        for (int i = 0; i < data.length; i++) {
//            numberOfColumns[i] = data[i].length;
//        }
//        return numberOfColumns;
//    }
//    public static void findMaxLengthOfAColumn(String[][] data){
//        int numberOfColumns = findMaxFromArray(findNumberOfColumn(data));
//        int[] maxSizesOfColumns = new int[numberOfColumns];
//        for (int i = 0; i < data.length; i++) {
//
//        }
//    }
//    public static int findMaxFromArray(int[] array){
//        int max = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] > max){
//                max = array[i];
//            }
//        }
//        return max;
//    }
}
