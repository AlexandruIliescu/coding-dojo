package leetcode.concepts.average_redistribution;

public class MinimizeMaximumOfArray {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, (int) intCeil(sum, i + 1));
        }
        return max;
    }

    public long intCeil(long a, int b) {
        if (a % b != 0) {
            return (a / b) + 1;
        } else
            return a / b;
    }
}
//https://leetcode.com/problems/minimize-maximum-of-array/description/