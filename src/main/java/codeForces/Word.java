package codeForces;

import java.util.Scanner;

public class Word {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int lowerCase = 0;
        int upperCase = 0;
        String toPrint;
        char[] chars = word.toCharArray();
        for (char character : chars) {
            if (Character.isLowerCase(character)) {
                lowerCase++;
            } else {
                upperCase++;
            }
        }
        if (lowerCase >= upperCase) {
            toPrint = word.toLowerCase();
        } else {
            toPrint = word.toUpperCase();
        }
        System.out.println(toPrint);
    }
}
/*Problem 59A - Word
 * https://codeforces.com/problemset/problem/59/A
 */