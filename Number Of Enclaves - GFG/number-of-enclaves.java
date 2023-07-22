//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int row, int column, int delrow[], int delcol[], int grid[][], int visited[][],
    int n, int m)
    {
        visited[row][column] = 1;
        
        for(int i = 0; i < 4; i++)
        {
            int r = row + delrow[i];
            int c = column + delcol[i];
            
            if(r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == 1)
            {
                dfs(r,c,delrow,delcol,grid,visited,n,m);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        
        for(int j = 0; j < m; j++)
        {
            if(grid[0][j] == 1 && visited[0][j] == 0)
            {
                dfs(0,j,delrow,delcol,grid,visited,n,m);
            }
            
            if(grid[n-1][j] == 1 && visited[n-1][j] == 0)
            {
                dfs(n-1,j,delrow,delcol,grid,visited,n,m);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(grid[i][0] == 1 && visited[i][0] == 0)
            {
                dfs(i,0,delrow,delcol,grid,visited,n,m);
            }
            
            if(grid[i][m-1] == 1 && visited[i][m-1] == 0)
            {
                dfs(i,m-1,delrow,delcol,grid,visited,n,m);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == 0) count++;
            }
        }
        return count;
        
    }
}