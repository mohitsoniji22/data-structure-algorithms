package epam.leetcode.blind75.mediam;

public class NoOfIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Boundary check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return;

        // Mark as visited
        grid[i][j] = 0;

        // Visit all 4 directions
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }

    public static void main(String[] args) {
        NoOfIslands200 solver = new NoOfIslands200();
        char[][] grid = {
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        int result = solver.numIslands(grid);
        System.out.println("Number of Islands = " + result); // Output: 3
    }
}
