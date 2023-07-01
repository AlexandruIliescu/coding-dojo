package leetcode.concepts.graphs_dfs_bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFS_KeysAndRooms {

    /**
     * This problem can be solved using Depth-First Search (DFS).
     * We start from room 0 and visit all rooms that can be accessed from room 0 (the keys in room 0).
     * We repeat this process until we've visited all rooms.
     * If we are able to visit all rooms, we return true; otherwise, false.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);

        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        if(visited[i]) return;
        visited[i] = true;
        for (int j : rooms.get(i)) {
            dfs(rooms, j, visited);
        }
    }

    public boolean canVisitAllRoomsIterative(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;
            visited[node] = true;

            for (int nei : rooms.get(node)) {
                if (!visited[nei]) {
                    stack.push(nei);
                }
            }
        }

        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }
}
