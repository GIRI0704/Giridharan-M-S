//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
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
    static char[][] fill(int n, int m, char grid[][])
    {
        // code here
        n = grid.length;
        m = grid[0].length;
        
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
        
        return grid;
    }
}