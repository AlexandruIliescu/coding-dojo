package leetcode.algo100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistanceArray {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(4);

        List<Integer> integers2 = new ArrayList<>();
        integers2.add(0);
        integers2.add(5);

        list.add(integers1);
        list.add(integers2);
        maxDistance1(list);
    }

    public static int maxDistance1(List<List<Integer>> arrays) {
        int minVal = Collections.min(arrays.get(0));
        int maxVal = Collections.max(arrays.get(0));
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = Collections.min(arrays.get(i));
            int currentMax = Collections.max(arrays.get(i));

            int distance1 = Math.abs(currentMax - minVal);
            int distance2 = Math.abs(maxVal - currentMin);

            maxDistance = Math.max(maxDistance, Math.max(distance1, distance2));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
    public static int maxDistance2(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            int distance1 = currentMax - minVal;
            distance1 = distance1 < 0 ? -distance1 : distance1;

            int distance2 = maxVal - currentMin;
            distance2 = distance2 < 0 ? -distance2 : distance2;

            maxDistance = maxDistance > distance1 ? maxDistance : distance1;
            maxDistance = maxDistance > distance2 ? maxDistance : distance2;

            minVal = minVal < currentMin ? minVal : currentMin;
            maxVal = maxVal > currentMax ? maxVal : currentMax;
        }

        return maxDistance;
    }
}
//https://leetcode.com/problems/maximum-distance-in-arrays/description/?envType=study-plan-v2&envId=premium-algo-100