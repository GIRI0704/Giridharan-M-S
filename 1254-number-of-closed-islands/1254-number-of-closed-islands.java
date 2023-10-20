class Solution {
    // The main function to count closed islands
    public int closedIsland(int[][] grid) {
        int m = grid.length;  // Number of rows in the grid
        int n = grid[0].length;  // Number of columns in the grid

        // Traverse the top and bottom boundaries of the grid
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);  // Call DFS for the top boundary
            dfs(grid, m - 1, j);  // Call DFS for the bottom boundary
        }

        // Traverse the left and right boundaries of the grid
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);  // Call DFS for the left boundary
            dfs(grid, i, n - 1);  // Call DFS for the right boundary
        }

        int res = 0;  // Initialize the result counter
        // Iterate through the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {  // If a land cell is not visited yet
                    res++;  // Increment the island count
                    dfs(grid, i, j);  // Call DFS to mark the entire island
                }
            }
        }
        return res;  // Return the total number of closed islands
    }

    // Depth-First Search function to mark an island
    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length;  // Number of rows in the grid
        int n = grid[0].length;  // Number of columns in the grid
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // If we go out of bounds, return (base case for DFS)
            return;
        }
        if (grid[i][j] == 1) {
            // If the cell is already marked as water, return (base case for DFS)
            return;
        }
        grid[i][j] = 1;  // Mark the current cell as visited
        // Recursively call DFS for adjacent cells
        dfs(grid, i + 1, j);  // Down
        dfs(grid, i, j + 1);  // Right
        dfs(grid, i - 1, j);  // Up
        dfs(grid, i, j - 1);  // Left
    }
}
