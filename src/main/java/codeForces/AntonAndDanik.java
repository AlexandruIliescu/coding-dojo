package codeForces;

import java.util.Scanner;

public class AntonAndDanik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int games = scanner.nextInt();
        scanner.nextLine();
        String rounds = scanner.nextLine();

        char charAnton = 'A';
        char charDanik = 'D';
        int antonWins = 0;
        int danikWins = 0;

        if (games >= 1 && games <= 100000 && games == rounds.length()) {
            for (int i = 0; i < rounds.length(); i++) {
                if (rounds.charAt(i) == charAnton) {
                    antonWins++;
                } else if (rounds.charAt(i) == charDanik) {
                    danikWins++;
                }
            }
            printTheWinner(antonWins, danikWins);
        }
    }

    private static void printTheWinner(int antonWins, int danikWins) {
        if (antonWins > danikWins) {
            System.out.println("Anton");
        } else if (danikWins > antonWins) {
            System.out.println("Danik");
        } else {
            System.out.println("Friendship");
        }
    }
}
/*Problem 734A - Anton and Danik
 * https://codeforces.com/problemset/problem/734/A
 */