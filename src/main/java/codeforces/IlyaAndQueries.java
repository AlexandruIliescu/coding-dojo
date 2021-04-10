package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class IlyaAndQueries {

    private final static Logger logger = Logger.getLogger(IlyaAndQueries.class.getName());
    public static final int ONE_CHARACTER_NUMBER = 4;

    public static void main(String[] args) {
        String characters = null;
        List<String> consoleQueriesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            characters = br.readLine();
            if (br.ready()) {
                br.readLine();
            }
            addConsoleQueriesToList(consoleQueriesList, br);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        computeQueries(characters, consoleQueriesList);
    }

    private static void addConsoleQueriesToList(List<String> consoleQueriesList, BufferedReader br) throws IOException {
        String line;
        while (br.ready() && (line = br.readLine()) != null) {
            consoleQueriesList.add(line);
        }
    }

    private static void computeQueries(String characters, List<String> consoleQueriesList) {
        if (consoleQueriesList.size() > 0) {
            consoleQueriesList.forEach(query -> {
                int startIndex = Integer.parseInt(query.substring(0, 1));
                int endIndex;
                if (query.length() < ONE_CHARACTER_NUMBER) {
                    endIndex = Integer.parseInt(query.substring(2, 3));
                } else {
                    endIndex = Integer.parseInt(query.substring(2, 4));
                }

                int output = getOutput(characters, startIndex, endIndex);
                System.out.println(output);
            });
        } else {
            int output = 0;
            for (int i = 0; i < characters.length(); i++) {
                char currentChar = characters.charAt(i);
                if (characters.length() > i + 1) {
                    char nextChar = characters.charAt(i + 1);
                    if (currentChar == nextChar) {
                        output++;
                    }
                    System.out.println(output);
                }
            }
        }
    }

    private static int getOutput(String characters, int startIndex, int endIndex) {
        int charactersIterations = endIndex - startIndex;
        int indexIncrement = 0;
        int output = 0;
        for (int i = 0; i < charactersIterations; i++) {
            String firstCharacter = String.valueOf(characters.charAt(startIndex - 1 + indexIncrement));
            String secondCharacter = String.valueOf(characters.charAt(startIndex + indexIncrement));
            indexIncrement++;
            if (firstCharacter.equals(secondCharacter)) {
                output++;
            }
        }
        return output;
    }
}
/*Problem 313B	- Ilya and Queries
 * https://codeforces.com/problemset/problem/313/B
 */