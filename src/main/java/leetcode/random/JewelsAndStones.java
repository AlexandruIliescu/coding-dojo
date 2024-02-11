package leetcode.random;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        char[] j = jewels.toCharArray();
        char[] s = stones.toCharArray();

        int result = 0;

        for (int i = 0; i < j.length; i++) {
            for (int k = 0; k < s.length; k++) {
                if (String.valueOf(j[i]).equals(String.valueOf(s[k]))) {
                    result++;
                }
            }
        }

        return result;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int result = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                result++;
            }
        }

        return result;
    }
}
//https://leetcode.com/problems/jewels-and-stones/