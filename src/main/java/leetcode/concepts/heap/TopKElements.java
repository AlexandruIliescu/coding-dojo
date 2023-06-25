package leetcode.concepts.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 4};
        findTopKElements(nums, 3);
        System.out.println("stop");
    }

    public static List<Integer> findTopKElements(int[] nums, int k) {
        //create a min heap (PriorityQueue) to store top-k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //iterate through the array
        for (int num : nums) {
            //add the current element to the min heap
            minHeap.offer(num);

            //if the size of the min heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //convert the min heap to a list and return it
        List<Integer> topKElements = new ArrayList<>(minHeap);
        return topKElements;
    }
}