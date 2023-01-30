package miscelaneous;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicates {
    public static void main(String[] args) {
        var nums = new int[]{-3, 2, 0, -3, 0, 0, 2, 56, 36, 98, -23, 56, 3, 3, 101, -12, 0, 0};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum |= nums[i];
        }
        ArrayList duplicateNumbers = new ArrayList<>();
        ArrayList duplicateCount = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }
                else {
                    if ((sum & nums[i]) == (sum & nums[j])){
                        count += 1;
                    }
                }
            }
            if (count > 1 && !duplicateNumbers.contains(nums[i])){
                duplicateNumbers.add(nums[i]);
                duplicateCount.add(count);
            }
        }
        String[][] duplicates = new String[duplicateNumbers.size()][2];
        for (int i = 0; i < duplicates.length; i++) {
            duplicates[i][0] = duplicateNumbers.get(i).toString();
            duplicates[i][1] = duplicateCount.get(i).toString();
        }
        TableDemo.printTable(new String[]{"Number", "Count"},duplicates);
    }
}
