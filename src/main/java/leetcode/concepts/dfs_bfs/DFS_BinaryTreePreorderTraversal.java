package leetcode.concepts.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_BinaryTreePreorderTraversal {

    private final List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorder(root);
        }
        return result;
    }

    private void preorder(TreeNode node) {
        result.add(node.val);

        if (node.left != null) {
            preorder(node.left);
        }

        if (node.right != null) {
            preorder(node.right);
        }
    }

    /*
     * Pre-order Traversal:
     * In a pre-order traversal, the node's value is accessed first,
     * then its left and right children are accessed, in that order.
     *
     * The procedure is as follows:
     * Visit the root node.
     * Traverse the left subtree by recursively calling the pre-order function.
     * Traverse the right subtree by recursively calling the pre-order function.
     */
}
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/