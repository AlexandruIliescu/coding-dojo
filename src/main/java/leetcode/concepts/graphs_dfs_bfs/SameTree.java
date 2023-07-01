package leetcode.concepts.graphs_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRecursion(p, q);
    }

    private boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val || (p.left == null && q.left != null) || (p.right == null && q.right != null))
            return false;

        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }

    private boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        boolean leftSame = isSameTreeDFS(p.left, q.left);
        boolean rightSame = isSameTreeDFS(p.right, q.right);

        return leftSame && rightSame;
    }

    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }
}
//https://leetcode.com/problems/same-tree/description/