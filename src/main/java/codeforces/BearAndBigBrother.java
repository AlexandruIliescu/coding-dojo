package codeforces;

import java.util.Scanner;

public class BearAndBigBrother {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limakWeight = Integer.parseInt(scanner.next());
        int bobWeight = Integer.parseInt(scanner.next());

        int count = 0;
        while (limakWeight <= bobWeight) {
            count++;
            limakWeight = limakWeight * 3;
            bobWeight = bobWeight * 2;
            if (limakWeight > bobWeight) {
                System.out.println(count);
                break;
            }
        }
    }
}
/*Problem 791A - Bear and Big Brother
 * https://codeforces.com/problemset/problem/791/A
 */