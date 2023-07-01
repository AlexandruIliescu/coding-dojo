package codingDojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

    //it requires that the array is sorted

    /**
     * Given a sorted (in ascending order) integer array nums of n elements and a target value,
     * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
     * <p>
     * divide and conquer
     */
    public int search(int[] nums, int target) {
        //if we have to sort the array
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //search on unsorted array
    public int searchUnsortedArray(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map.getOrDefault(target, -1);
    }
}
