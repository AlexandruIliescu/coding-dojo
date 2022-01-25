package practice;

public class PracticeArrays {

    // Returns the distance between the two closest numbers.
    static int distClosestNumbers(int[] numbers) {
        java.util.Arrays.sort(numbers);
        int numberToPrint = 100;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] < numberToPrint) {
                numberToPrint = numbers[i + 1] - numbers[i];
            }
        }
        return numberToPrint;
    }

    public static void main(String[] args) {
        //test 
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int result = distClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }
}