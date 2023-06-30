package leetcode.concepts.dfs_bfs.dfs_traversal;

import leetcode.concepts.dfs_bfs.Vertex;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch<T> {

    public static void main(String[] args) {
        //directed graph
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(Arrays.asList(v0));

        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.iterativeTraverse(v0);
//        dfs.traverseRecursively(v0);
    }

    public void iterativeTraverse(Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();

            //due to the link between v0 and v6, without if
            //we will have an infinite loop because they will
            //continue to be added to the stack
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);

                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public void recursiveTraverse(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);

        vertex.getNeighbors().forEach(neighbor -> {
            if (!neighbor.isVisited()) {
                recursiveTraverse(neighbor);
            }
        });
    }
}
