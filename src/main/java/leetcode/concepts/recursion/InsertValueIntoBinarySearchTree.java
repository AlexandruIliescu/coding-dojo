package leetcode.concepts.recursion;

import leetcode.concepts.recursion.utils.BinaryTreeNodes;

public class InsertValueIntoBinarySearchTree {

    public static BinaryTreeNodes insertNode(BinaryTreeNodes head, int data) {
        // If the current node is null, create a new node with the given data and return it
        if (head == null) {
            head = new BinaryTreeNodes();
            head.data = data;
            return head;
        }

        // If the data is greater than the current node's data, recursively insert it on the right branch
        if (head.data < data) {
            head.right = insertNode(head.right, data);
        }
        // Otherwise, the data is less than or equal to the current node's data, so recursively insert it on the left branch
        else {
            head.left = insertNode(head.left, data);
        }

        // Return the modified node
        return head;
    }
}