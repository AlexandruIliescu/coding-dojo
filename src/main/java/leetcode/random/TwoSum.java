package leetcode.random;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        for (int num : twoSum(nums, target)) {
            System.out.println(num);
        }
    }

    /**
     * TC O(n)
     * SC O(n), in worst case, we need to store all the elements in the HashMap
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
}
//https://leetcode.com/problems/two-sum/