package leetcode.concepts.graphs_dfs_bfs.bfs_traversal;

import leetcode.concepts.graphs_dfs_bfs.Vertex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {

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

        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
        bfs.traverse(v0);
    }

    public void traverse(Vertex<T> startVertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbors());
            }
        }
    }
}