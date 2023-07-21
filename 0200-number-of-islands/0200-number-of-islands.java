class Solution {
     public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    
    public void dfs(int row, int column, char[][] grid, int visited[][])
    {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || column < 0 || column >= m || visited[row][column] == 1 || grid[row][column] == '0') {
            return;
        }

        visited[row][column] = 1;

        // Explore all four directions: up, down, left, right
        dfs(row - 1, column, grid, visited);
        dfs(row + 1, column, grid, visited);
        dfs(row, column - 1, grid, visited);
        dfs(row, column + 1, grid, visited);
    }
//         Queue<pair> q = new ArrayDeque();
        
//         q.add(new pair(row, column));
//         int n = grid.length;
//         int m = grid[0].length;
        
//         while(q.size() > 0)
//         {
//             pair temp = q.remove();
//             int row1 = temp.first;
//             int column1 = temp.second;
            
//             for(int i = -1; i <= 1; i++)
//             {
//                 for(int j = -1; j <= 1; j++)
//                 {
//                     if(i != j)
//                     {
//                         int nrow = row1 + i;
//                     int ncolumn = column1 + j;
                    
//                     if(nrow >= 0 && nrow < n && ncolumn >= 0 && ncolumn < m && 
//                     visited[nrow][ncolumn] == 0 && grid[nrow][ncolumn] == '1')
//                     {
//                         visited[nrow][ncolumn] = 1;
//                         q.add(new pair(nrow, ncolumn));
//                     }
//                     }
                    
//                 }
//             }
//         }
    
    
    class pair
    {
        int first;
        int second;
        
        pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
}