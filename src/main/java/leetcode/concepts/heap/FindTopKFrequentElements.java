package leetcode.concepts.heap;

import java.util.*;

public class FindTopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequentWithPriorityQueue(nums, k);
        System.out.println(result);
    }

    public static int[] topKFrequentWithPriorityQueue(int[] nums, int k) {
        //build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            //returns the value to which the specified key is mapped
            //if the key is not found, returns 0 (defaultValue)
            //if found, returns the value and increments it + 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //build the min-heap (priority queue)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        //iterate through the frequency map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                //removes the element with the smallest frequency in the minHeap
                minHeap.poll();
            }
        }

        //build the result array
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }

    public static int[] topKFrequentWithCollections(int[] nums, int k) {
        //build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //sort the entries of the frequency map based on their values in descending order
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        //extract the top-k frequent elements from the sorted entries
        int[] topKFrequentElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentElements[i] = entries.get(i).getKey();
        }

        return topKFrequentElements;
    }

}
//https://leetcode.com/problems/top-k-frequent-elements/