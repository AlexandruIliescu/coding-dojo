package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abbreviation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String chars = input.nextLine();

        String[] splitWords = chars.split("\\W");
        List<String> abbreviatedWords = new ArrayList<>();
        for (String word : splitWords) {
            if (word.length() >= 4) {
                abbreviatedWords.add(abbreviate(word));
            } else {
                abbreviatedWords.add(word);
            }
        }

        List<String> specialChars = new ArrayList<>();
        for (Character character : chars.toCharArray()) {
            if (character.toString().matches("\\W")) {
                specialChars.add(character.toString());
            }
        }

        List<String> listToPrint = new ArrayList<>();
        for (int i = 0; i < abbreviatedWords.size(); i++) {
            listToPrint.add(abbreviatedWords.get(i));
            if (specialChars.size() > i) {
                listToPrint.add(specialChars.get(i));
            }
        }
        listToPrint.forEach(System.out::print);
    }

    private static String abbreviate(String input) {
        return input.substring(0, 1)
                + (input.length() - 2)
                + input.substring(input.length() - 1);
    }
}