package practice.challenge;

import java.util.*;

public class CodingChallenge {

    public static void main(String[] args) {
        System.out.println("hello world!");
    }

    public static int getMinMoves(List<Integer> plates) {
        int n = plates.size();
        List<Integer> sortedPlates = new ArrayList<>(plates);
        Collections.sort(sortedPlates);

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            plates.set(i, sortedPlates.get(i));
        }

        for (int i = 1; i < n - 1; i += 2) {
            int temp = plates.get(i);
            plates.set(i, plates.get(i + 1));
            plates.set(i + 1, temp);
        }

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(plates.get(i), i);
        }

        for (int i = 0; i < n; i++) {
            while (plates.get(i) != sortedPlates.get(i)) {
                int swapWithIndex = index.get(sortedPlates.get(i));
                Collections.swap(plates, i, swapWithIndex);
                index.put(plates.get(swapWithIndex), swapWithIndex);
                swaps++;
            }
        }

        return swaps;
    }
}
