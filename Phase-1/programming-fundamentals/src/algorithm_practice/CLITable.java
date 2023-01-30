package algorithm_practice;

public class CLITable {
    public static void main(String[] args) {

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
}
