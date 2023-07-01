package practice.challenge;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodingChallenge2 {

    public static void main(String[] args) {
        CodingChallenge2 test = new CodingChallenge2();
        Scanner scanner = new Scanner(System.in);
        System.out.println(test.formatString(scanner.next(), scanner.next()));
    }

    public int formatString(String str1, String str2) {
        int countString = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char stringCharacter : str1.toCharArray()) {
            map.put(stringCharacter, map.getOrDefault(stringCharacter, 0) + 1);
        }
        for (char stringCharacter : str2.toCharArray()) {
            map.put(stringCharacter, map.getOrDefault(stringCharacter, 0) - 1);
        }
        Collection<Integer> count = map.values();
        for (int value : count) {
            countString += value;
        }
        return countString;
    }
}
//2 strings as input
//output should be an int representing the number of characters that should be deleted so those 2 strings to be anagrams