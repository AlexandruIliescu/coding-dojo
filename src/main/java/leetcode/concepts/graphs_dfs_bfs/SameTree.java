package leetcode.concepts.graphs_dfs_bfs;

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
}
//https://leetcode.com/problems/same-tree/description/