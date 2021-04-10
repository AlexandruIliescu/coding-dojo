package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coins {

    public static void main(String[] args) {
        int testCases = 0;
        List<String> consoleQueriesList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        testCases = scan.nextInt();

        while (scan.hasNextInt()) {
            String input = scan.next();
            if (!scan.hasNext() && !scan.hasNextLine()) {
                break;
            }
            consoleQueriesList.add(input);
        }

        System.out.println(consoleQueriesList);


    }
}
//https://codeforces.com/problemset/problem/1294/A

/*
5
5 3 2 8
100 101 102 105
3 2 1 100000000
10 20 15 14
101 101 101 3
 */