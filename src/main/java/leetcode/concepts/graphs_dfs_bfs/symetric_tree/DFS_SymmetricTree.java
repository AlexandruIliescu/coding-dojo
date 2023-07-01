package leetcode.concepts.graphs_dfs_bfs.symetric_tree;

public class DFS_SymmetricTree {

    /**
     * Two trees are a mirror reflection of each other if:
     *
     * Their two roots have the same value.
     * The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetricDFS2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorDFS2(root.left, root.right);
    }

    private boolean isMirrorDFS2(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return isMirrorDFS2(node1.left, node2.right) && isMirrorDFS2(node1.right, node2.left);
    }
}
//https://leetcode.com/problems/symmetric-tree/description/