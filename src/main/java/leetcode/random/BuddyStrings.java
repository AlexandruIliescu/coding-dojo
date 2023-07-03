package leetcode.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {

        // Step 1: Check if the lengths of the strings are equal
        if (s.length() != goal.length())
            return false;

        // Step 2: Check if the strings are identical
        if (s.equals(goal)) {
            // If the strings are identical, we can only swap characters if there are duplicate characters in s
            Set<Character> uniqueChars = new HashSet<>();
            for (char ch : s.toCharArray()) {
                if (!uniqueChars.add(ch))
                    return true;
            }
            return false;
        }

        // Step 3: Find the differing characters in the strings
        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndices.add(i);
            }
        }

        // Step 4: Check if there are exactly two differing characters
        if (diffIndices.size() != 2)
            return false;

        // Step 5: Check if the characters can be swapped to obtain goal
        int index1 = diffIndices.get(0);
        int index2 = diffIndices.get(1);
        return s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1);
    }
}
//https://leetcode.com/problems/buddy-strings/description/