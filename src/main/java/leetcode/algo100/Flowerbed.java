package leetcode.algo100;

public class Flowerbed {

    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;
        int i = 0;

        while (i < length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }

        return count >= n;
    }
}
//https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75