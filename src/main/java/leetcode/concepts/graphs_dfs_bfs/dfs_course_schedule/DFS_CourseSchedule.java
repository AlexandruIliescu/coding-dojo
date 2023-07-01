package leetcode.concepts.graphs_dfs_bfs.dfs_course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS_CourseSchedule {

    // Initialize a graph represented as adjacency list and two boolean arrays to keep track of visited nodes.
    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] path;
    private boolean[] onStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize the adjacency list and the boolean arrays.
        graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        onStack = new boolean[numCourses];

        // Fill in the adjacency list for each course.
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Transform the prerequisites matrix to an adjacency list.
        for (int[] prerequisite : prerequisites) {
            // For each pair [a, b], we add an edge from node b to node a in the graph.
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        // For each course, check if a cycle exists.
        for (int i = 0; i < numCourses; i++) {
            // If the course has not been visited and a cycle is detected, return false.
            if (!visited[i] && hasCycleRecursive(i)) {
                return false;
            }
        }

        // If no cycles detected for all courses, return true.
        return true;
    }

    private boolean hasCycleRecursive(int node) {
        // If the current node is already in the current path, a cycle is detected.
        if (path[node]) return true;
        // If the current node is already visited and there's no cycle, then skip it.
        if (visited[node]) return false;

        // Mark the current node as visited and add it to the current path.
        visited[node] = true;
        path[node] = true;

        // For each neighbor of the current node, visit it and check for a cycle.
        for (int neighbor : graph[node]) {
            if (hasCycleRecursive(neighbor)) {
                return true;
            }
        }

        // After visiting all neighbors, remove the node from the current path.
        path[node] = false;
        // No cycle detected from the current node.
        return false;
    }

    private boolean hasCycleIterative(int startNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while(!stack.isEmpty()) {
            int node = stack.peek();

            if(!visited[node]) {
                visited[node] = true;
                onStack[node] = true;

                for(int neighbor : graph[node]) {
                    if(!visited[neighbor]) {
                        stack.push(neighbor);
                    } else if(onStack[neighbor]) {
                        return true;
                    }
                }
            } else {
                onStack[node] = false;
                stack.pop();
            }
        }

        return false;
    }
}
//https://leetcode.com/problems/course-schedule/