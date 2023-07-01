package leetcode.concepts.graphs_dfs_bfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS_KtkLargestSumInABinaryTree {

    /**
     *  The best approach would be to perform a breadth-first search (BFS) because
     *   allows us to easily process all nodes at each level of the tree.
     *
     *   Level Order Traversal (BFS): Start from the root and traverse each level of the binary tree,
     *   summing up the values of nodes at each level.
     *
     *   Priority Queue: As we need the kth largest sum, maintain a min heap of size k.
     *   If the size of the heap is less than k, push the new level sum into the heap.
     *   If the size is equal to k, compare the new level sum with the top element of the heap.
     *   If the new sum is larger, pop the top element and push the new sum into the heap.
     *
     *   Final Output: The top element of the heap will be our answer, i.e., the kth largest level sum.
     *   If the tree has fewer than k levels, we return -1.
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += (long)currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            if (minHeap.size() < k) {
                minHeap.offer(levelSum);
            } else if (minHeap.peek() < levelSum) {
                minHeap.poll();
                minHeap.offer(levelSum);
            }
        }

        return (minHeap.size() < k) ? -1 : minHeap.peek();
    }
}
//https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/