package codingDojo;

public class NumberOfIslands {
    //https://leetcode.com/problems/number-of-islands/

    public static void main(String[] args) {
       char[][] grid = {
               {'1', '1', '0'},
               {'1', '1', '0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if(grid == null) {
            return 0;
        }
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    //increase island count
                    ++islandCount;
                    //change any other land connected to zeros
                    changeLandToWater(grid, i, j);
                }
            }
        }
        return islandCount;
    }
    private static void changeLandToWater(char[][]grid, int i, int j) {
        //1. row less 0
        //2. row greater than grid.length (row length)
        //3. column is less 0
        //4. column greater than grid[0].length (column length)
        //5. if position is a '0'
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        //we know the position must be a '1'
        grid[i][j] = '0';
        changeLandToWater(grid, i - 1, j); //down
        changeLandToWater(grid, i + 1, j); //up
        changeLandToWater(grid, i, j - 1); //left
        changeLandToWater(grid, i, j + 1); //right
    }
}