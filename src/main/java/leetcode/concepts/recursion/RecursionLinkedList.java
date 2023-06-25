package leetcode.concepts.recursion;

import leetcode.concepts.recursion.utils.Node;

import java.util.LinkedList;

public class RecursionLinkedList {

    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
//        reverseLinkedList(list);
//        System.out.println("stop");

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.setNext(n2);
        n2.setNext(n3);

        printLinkedList(n1);
        Node reversed = reverseList(n1);
        System.out.println("");
        printLinkedList(reversed);

    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }

        int lastElement = list.removeLast();
        LinkedList<Integer> reversedList = reverseLinkedList(list);
        reversedList.addFirst(lastElement);

        return reversedList;
    }

    public static Node reverseList(Node node) {
        if (node == null || node.next == null) return node;
        Node p = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    private static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.getNext();
        }
    }
}