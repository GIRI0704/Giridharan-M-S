class Solution {
    static void dfs(int row, int column, int delrow[], int delcol[],
    char grid[][], int visited[][], int n, int m)
    {
        visited[row][column] = 1;
        for(int i = 0; i < 4; i++)
        {
            int r = row + delrow[i];
            int c = column + delcol[i];
            if(r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == 'O')
            {
                dfs(r,c,delrow,delcol,grid,visited,n,m);
            }
        }
    }
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][]= new int[n][m];
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        for(int j = 0; j < m; j++)
        {
            if(grid[0][j] == 'O' && visited[0][j] == 0)
            {
                dfs(0,j,delrow,delcol,grid,visited,n,m);
            }
            
            if(grid[n-1][j] == 'O' && visited[n-1][j] == 0)
            {
                dfs(n-1,j,delrow,delcol,grid,visited,n,m);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(grid[i][0] == 'O' && visited[i][0] == 0)
            {
                dfs(i,0,delrow,delcol,grid,visited,n,m);
            }
            
            if(grid[i][m-1] == 'O' && visited[i][m-1] == 0)
            {
                dfs(i,m-1,delrow,delcol,grid,visited,n,m);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 'O' && visited[i][j] == 0)
                {
                    visited[i][j] = 1;
                    grid[i][j] = 'X';
                }
            }
        }
        
        System.out.println(Arrays.toString(grid));
    }
}