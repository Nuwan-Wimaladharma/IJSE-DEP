package lk.ijse.dep10.ds.util;

import java.util.Arrays;

public class DynamicArray {
    int[] array = new int[0];
    public void add(String value) {
        int newValue = Integer.parseInt(value);
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < newArray.length-1; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length-1] = newValue;
        array = newArray;
    }
    public String printArray(){
        return Arrays.toString(array);
    }

    public void clear() {
        int[] newArray = new int[0];
        array = newArray;
    }

    public boolean contains(String input) {
        boolean isHere = false;
        int enteredNumber = Integer.parseInt(input);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == enteredNumber){
                isHere = true;
            }
        }
        return isHere;
    }

    public int size() {
        return array.length;
    }

    public void remove(int index) {
        int[] newArray = new int[array.length-1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index+1; i < array.length; i++) {
            newArray[i-1] = array[i];
        }
        array = newArray;
    }

    public String get(int index) {
        int searchingNumber = array[index];
        String outputNumber = Integer.toString(searchingNumber);
        return outputNumber;
    }
}
