package leetcode.concepts.graphs_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_GraphValidTree {

    /**
     * A graph forms a valid tree if it satisfies the following two conditions:
     *
     * There are no cycles.
     * All nodes are connected.
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(adjList, 0, visited, -1)) {
            return false;
        }

        for (boolean visit : visited) {
            if (!visit) return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int adj : adjList.get(node)) {
            if (!visited[adj]) {
                if (hasCycle(adjList, adj, visited, node)) {
                    return true;
                }
            } else if (adj != parent) {
                return true;
            }
        }
        return false;
    }
}
//https://leetcode.com/problems/graph-valid-tree/description/