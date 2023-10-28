package leetcode.random;

import java.util.HashMap;
import java.util.Map;

public class FindTargetAsSum {

    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 11};
        int target = 9;

        for (int i : twoSum(nums, target)) {
            System.out.println(i);
        }
    }

    /*
     * TC: O(n)
     * SC: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
