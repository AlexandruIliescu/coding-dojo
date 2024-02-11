package coding_dojo;

public class FizzBuzz {

    public static String gameValue(int i) {
        if (i == 0) {
            return "0";
        }

        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        if (i % 3 == 0 || String.valueOf(i).contains("3")) {
            return "Fizz";
        }
        if (i % 5 == 0 || String.valueOf(i).contains("5")) {
            return "Buzz";
        }

        return String.valueOf(i);
    }
}