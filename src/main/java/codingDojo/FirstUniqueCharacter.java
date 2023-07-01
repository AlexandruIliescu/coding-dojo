package codingDojo;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    //https://leetcode.com/problems/first-unique-character-in-a-string/

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if(countMap.containsKey(letter)) {
                countMap.put(letter, countMap.get(letter) + 1);
            } else {
                countMap.put(letter, 1);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if(countMap.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }
}
