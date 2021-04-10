package codewars;

import java.util.Arrays;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int[] newArray = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (!isElementDuplicated(newArray, elements[i], maxOccurrences)) {
                newArray[i] = elements[i];
            }
        }
        int n = 0;
        for (int value : newArray) {
            if (value != 0) {
                n++;
            }
        }
        int[] arrayToPrint = new int[n];
        int j = 0;
        for (int value : newArray) {
            if (value != 0) {
                arrayToPrint[j] = value;
                j++;
            }
        }
        return arrayToPrint;
    }

    private static boolean isElementDuplicated(int[] arrayValues, int valueToCompare, int maxOccurrences) {
        int count = 0;
        for (int arrayValue : arrayValues) {
            if (arrayValue == valueToCompare) {
                count++;
            }
        }
        return count >= maxOccurrences;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 2, 2, 3, 3, 5}, 2)));
    }
}
//https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/java