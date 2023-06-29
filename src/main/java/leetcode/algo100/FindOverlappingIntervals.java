package leetcode.algo100;

import java.util.ArrayList;
import java.util.List;

public class FindOverlappingIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{3, 7}, {4, 9}, {12, 30}};
        for (int[] array : mergeIntervals(arrays)) {
            for (int value : array) {
                System.out.println(value);
            }
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = merged.get(merged.size() - 1);

            if (curr[0] <= prev[1]) {
                //the current interval overlaps with the previous interval
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                //no overlap, add the current interval to the result
                merged.add(curr);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}