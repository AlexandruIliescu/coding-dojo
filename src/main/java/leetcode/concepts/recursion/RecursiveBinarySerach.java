package leetcode.concepts.recursion;

public class RecursiveBinarySerach {

    public static void main(String[] args) {
    int[] array = {1, 2, 5, 10, 35, 56, 76};
        System.out.println(binarySearch(array, 0, 6, 10));
    }

    /**
     * time complexity O(log n)
     * space complexity O(log n)
     */
    private static int binarySearch(int[] array, int left, int right, int x) {
        // Base case: element not found
        if (left > right) {
            return -1;
        }

        // Calculate the middle index
        int mid = (left + right) / 2;

        // Check if the middle element is the target element
        if (x == array[mid]) {
            return mid;
        }

        // If the target element is smaller than the middle element, search in the left half
        if (x < array[mid]) {
            return binarySearch(array, left, mid - 1, x);
        }
        // If the target element is larger than the middle element, search in the right half
        return binarySearch(array, mid + 1, right, x);
    }
}