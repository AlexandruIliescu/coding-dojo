package codingDojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInArray {

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        //time complexity O(n)
        //we must touch each element a single time

        //space complexity O(1)
        //if we consider the result as extra space
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                output.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return output;
    }

    public List<Integer> findDuplicatesWithSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for(int num : nums) {
            if(seen.contains(num)) {
                output.add(num);
            } else {
                seen.add(num);
            }
        }
        return output;
    }
}