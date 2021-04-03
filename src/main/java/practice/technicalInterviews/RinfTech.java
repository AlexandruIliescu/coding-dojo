package practice.technicalInterviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RinfTech {

    public static void main(String[] args) {
        RinfTech test = new RinfTech();
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
//input 2 string-uri
//output un int cu nr. de caractere de sters a.i. cele 2 string-uri sa fie anagrame