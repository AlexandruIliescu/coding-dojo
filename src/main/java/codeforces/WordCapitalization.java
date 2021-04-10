package codeforces;

import java.util.Scanner;

public class WordCapitalization {

    private static final int MAX_WORD_LENGHT = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() <= MAX_WORD_LENGHT) {
            char[] inputChar = input.toCharArray();
            String firstLetter = String.valueOf(inputChar[0]);
            String replacedFirstLetter = firstLetter.toUpperCase();

            StringBuilder sb = new StringBuilder();
            sb.append(replacedFirstLetter);
            sb.append(input);
            sb.deleteCharAt(1);

            System.out.println(sb.toString());
        }
    }
}
/*Problem 281A	- Word Capitalization
 * https://codeforces.com/problemset/problem/281/A
 */