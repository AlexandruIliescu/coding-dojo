package leetcode.concepts.graphs_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_BinaryTreeInorderTraversal {

    //initialize the output list
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //if the tree is not empty, start the in-order traversal
        if (root != null) {
            inorder(root);
        }
        //return the result list containing nodes values in in-order
        return result;
    }

    private void inorder(TreeNode node) {
        //recursively call the function on the left child
        if (node.left != null) {
            inorder(node.left);
        }
        //visit the node
        result.add(node.val);
        //recursively call the function on the right child
        if (node.right != null) {
            inorder(node.right);
        }
    }

    /*
     * In-order Traversal:
     * In an in-order traversal, the left subtree is accessed first,
     * then the node's value, and then the right subtree.
     *
     * The procedure is as follows:
     * Traverse the left subtree by recursively calling the in-order function.
     * Visit the root node.
     * Traverse the right subtree by recursively calling the in-order function.
     */
}
//https://leetcode.com/problems/binary-tree-inorder-traversal/