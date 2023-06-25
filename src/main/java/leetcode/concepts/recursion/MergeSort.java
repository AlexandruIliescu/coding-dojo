package leetcode.concepts.recursion;

public class MergeSort {

    public static void main(String[] args) {
        int[] data = new int[]{-5, 20, 10, 3, 2, 0};
        mergeSort(data, 0, data.length - 1);
        System.out.println("stop");
    }

    private static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    private static void merge(int[] data, int start, int mid, int end) {
        // Create a temporary array to store the merged subarray
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        // Merge the two sorted subarrays in sorted order
        while (i <= mid && j <= end) {
            // Compare the elements from the two subarrays
            if (data[i] <= data[j]) {
                // If the element in the left subarray is smaller or equal, add it to the merged array
                temp[k++] = data[i++];
            } else {
                // If the element in the right subarray is smaller, add it to the merged array
                temp[k++] = data[j++];
            }
        }
        // Add any remaining elements from the left subarray to the merged array
        while (i <= mid) {
            temp[k] = data[i];
            k++;
            i++;
        }
        // Add any remaining elements from the right subarray to the merged array
        while (j <= end) {
            temp[k++] = data[j++];
        }
        // Copy the merged elements from the temporary array back to the original array
        for (i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }
    }
}