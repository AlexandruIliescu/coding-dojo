package leetcode.concepts.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * When finding the top k numbers that are greater than others in an array,
 * using a heap structure is typically more efficient than using a sorting algorithm.
 * <p>
 * Sorting Algorithm:
 * Time Complexity: O(n log n), where n is the size of the input array.
 * This is the time complexity of most efficient sorting algorithms like Quicksort or Mergesort.
 * Space Complexity: O(1) or O(n), depending on whether the sorting algorithm is in-place or requires additional space.
 * <p>
 * Heap Structure:
 * Time Complexity: O(n log k), where n is the size of the input array and k is the number of elements to find.
 * Building the heap takes O(n) time, and extracting the top k elements takes O(k log n) time.
 * Space Complexity: O(k), as we only need to maintain a heap of size k to track the top k elements.
 */
public class FindKLargestElements {


    /**
     * Quicksort algorithm
     */
    public static int findKthLargestWithQuickSort(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex > k - 1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return -1; // kth largest element not found
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Time complexity O((n - k) log k)
     * Building the initial heap: Adding the first k elements to the heap takes O(k log k) time complexity.
     * Since k is a constant value, this can be considered as O(1) in terms of complexity.
     * <p>
     * Processing the remaining elements: Iterating over the remaining elements in the array
     * takes O((n - k) log k) time complexity. For each element, we compare it with the root of the heap and potentially
     * replace the root. This operation takes O(log k) time complexity.
     * <p>
     * Hence, the overall time complexity is dominated by the processing of the remaining elements,
     * resulting in O((n - k) log(k)) complexity.
     */
    public int findKthLargestWithHeap(int[] nums, int k) {
        //create a min-heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //add the first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        //process the remaining elements
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];

            //if the current element is larger than the root of the heap,
            //replace the root with the current element
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        //return the root of the heap, which is the kth largest element
        return minHeap.peek();
    }

    /**
     * The time complexity of the given code is determined by the sorting algorithm used by Arrays.sort().
     * The complexity can vary depending on the implementation of the sorting algorithm.
     * Time complexity: O(n log(n)), does not meet the requirements of O(n)
     * <p>
     * Arrays.sort(nums) uses a Dual-Pivot Quicksort that offers O(n log(n)) time complexity
     */
    public int findKthLargestNonEfficient(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}