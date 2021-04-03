package codeForces;

import static java.lang.Integer.parseInt;

import java.util.Scanner;

public class WrongSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = parseInt(scanner.next());
        int k = parseInt(scanner.next());

        for (int i = 0; i < k; k--) {
            if (n % 10 == 0) {
                n = n / 10;
            } else {
                n--;
            }
        }
        System.out.println(n);
    }
}
/*Problem 977A - Wrong Subtraction
 * https://codeforces.com/problemset/problem/977/A
 */