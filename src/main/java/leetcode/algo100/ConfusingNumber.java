package leetcode.algo100;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {

    public static void main(String[] args) {

    }

    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);

        int newNum = 0;
        int x = n;
        while (x != 0) {
            int reminder = x % 10;
            if (!map.containsKey(reminder)) {
                return false;
            }
            if (newNum > Integer.MAX_VALUE / 10) {
                return false;
            }
            newNum = newNum * 10 + map.get(reminder);
            x /= 10;
        }
        return n == newNum ? false : true;
    }
}
//https://leetcode.com/problems/confusing-number/description/?envType=study-plan-v2&envId=premium-algo-100