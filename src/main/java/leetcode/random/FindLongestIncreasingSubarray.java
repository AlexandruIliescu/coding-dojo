package leetcode.random;

public class FindLongestIncreasingSubarray {

    public static int findLongestIncreasingSubarray(int[] nums) {
        int start = 0; // Start index of the current increasing subarray
        int end = 0; // End index of the current increasing subarray
        int maxLen = 1; // Maximum length of the increasing subarray

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // If the current element is greater than the previous element,
                // it is part of the increasing subarray
                end = i; // Update the end index of the subarray
            } else {
                // If the current element is not greater than the previous element,
                // the increasing subarray has ended
                maxLen = Math.max(maxLen, end - start + 1); // Update the maximum length if necessary
                start = i; // Move the start index to the current element
                end = i; // Move the end index to the current element
            }
        }

        // Check if the last subarray is the longest increasing subarray
        maxLen = Math.max(maxLen, end - start + 1);

        return maxLen;
    }
}
