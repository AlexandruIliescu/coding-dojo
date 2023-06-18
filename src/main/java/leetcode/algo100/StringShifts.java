package leetcode.algo100;

public class StringShifts {

    public static void main(String[] args) {

    }

    public String stringShift(String s, int[][] shift) {
        String result = null;

        for (int i = 0; i < shift.length; i++) {
            boolean shiftLeft = false;
            boolean shiftRight = false;
            int amount = shift[i][1];

            if (shift[i][0] == 0) {
                shiftLeft = true;
            } else {
                shiftRight = true;
            }

            if (shiftLeft && i == 0) {
                String valueToShift = s.substring(0, amount);
                String temp = s.replace(valueToShift, "");
                result = temp + valueToShift;
            }
        }
        return result;
    }

}
//https://leetcode.com/problems/perform-string-shifts/?envType=study-plan-v2&envId=premium-algo-100