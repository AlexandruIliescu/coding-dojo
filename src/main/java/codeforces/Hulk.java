package codeforces;

import java.util.Scanner;

public class Hulk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.next());
        String hulksHate = "I hate";
        String hulsLove = "I love";
        String it = " it";
        String that = " that ";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= input; i++) {
            if (i % 2 != 0) {
                if (sb.toString().equals("")) {
                    sb.append(hulksHate);
                } else if (sb.toString().contains("love")) {
                    sb.append(that).append(hulksHate);
                }
            }
            if (i % 2 == 0) {
                if (sb.toString().contains("hate")) {
                    sb.append(that).append(hulsLove);
                }
            }
        }
        System.out.println(sb.append(it).toString());
    }
}
/*Problem 705A - Hulk
 * https://codeforces.com/problemset/problem/705/A
 */