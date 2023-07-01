package leetcode.concepts.two_pointers;

public class TP_ContainerWithMostWater {

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
//https://leetcode.com/problems/container-with-most-water/