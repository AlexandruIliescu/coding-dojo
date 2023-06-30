package leetcode.concepts.dfs_bfs;

public class DFS_NumberOfIslands {

    /**
     * The problem can be solved by applying Depth-First Search (DFS) (or Breadth-First Search (BFS) on each cell)
     *
     * iterates through each cell of the grid. When it encounters a '1' (representing an island),
     * it performs a depth-first search to visit all the connected cells in the island, and it marks these cells as
     * visited by setting their value to '0'.
     * The count of islands (numIslands) is incremented each time a new unvisited island is found.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     * m - number of rows
     * n - number of columns
     */
    public int numIslands(char[][] grid) {
        //we can implement this using DFS
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    /**
     * The dfs method takes the grid and a starting cell as input and visits all the cells in the island.
     * If the current cell is out of bounds or is not an island (cell value is '0'), it returns 0. Otherwise,
     * it marks the current cell as visited and then recursively visits the neighboring cells.
     * It finally returns 1 to indicate that an island has been found.
     */
    private int dfs(char[][] grid, int i, int j) {
        //if out of bounds or the cell is not an island, return 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        //mark the cell as visited
        grid[i][j] = '0';

        //visit all neighbors
        dfs(grid, i - 1, j); //up
        dfs(grid, i + 1, j); //down
        dfs(grid, i, j - 1); //left
        dfs(grid, i, j + 1); //right

        return 1;
    }
}