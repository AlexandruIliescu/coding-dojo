package leetcode.concepts.two_pointers;

public class TP_MovePiecesToObtainString {

    /**
     * Initialize two pointers at the beginning of both the start and target strings
     * and move them forward whenever you encounter a '_' or when the characters in both strings
     * match and the movement direction is correct.
     * <p>
     * Time complexity: O(n) - n is number of the input strings
     * Space complexity: O(1) - we use a fixed amount of space to store the input strings
     * and the index variables i and j
     */
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;

        while (i < start.length() && j < target.length()) {
            //skip blank spaces
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }

            //check if we've reached the end of either string
            if ((i < start.length() && j >= target.length()) || (i >= start.length() && j < target.length())) {
                return false;
            }
            if (i == start.length() && j == target.length()) {
                return true;
            }

            //check that the characters are the same and that they're moving in the right direction
            if (start.charAt(i) != target.charAt(j) ||
                    (start.charAt(i) == 'L' && i < j) ||
                    (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        //check if there are remaining non-space characters in either string
        while (i < start.length() && start.charAt(i) == '_') {
            i++;
        }
        while (j < target.length() && target.charAt(j) == '_') {
            j++;
        }

        return i == start.length() && j == target.length();
    }
}
//https://leetcode.com/problems/move-pieces-to-obtain-a-string/