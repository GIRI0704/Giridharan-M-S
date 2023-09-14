//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends






// User function Template for Java
class pair
{
    int row;
    int col;
    pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    void bfs(int i, int j, int n, int m, int grid[][], int visited[][])
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(i,j));
        visited[i][j] = 1;
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        
        while(q.size() > 0)
        {
            int r = q.peek().row;
            int c = q.peek().col;
            
            q.remove();
            
            for(int x = 0; x < 4; x++)
            {
                int row = r+delrow[x];
                int column = c+delcol[x];
                if(row >= 0 && row < n && column >= 0 && column < m && grid[row][column] == 1 && visited[row][column] ==0)
                {
                    visited[row][column] = 1;
                    q.add(new pair(row,column));
                }
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        for(int i = 0; i < n; i++)
        {
            if(grid[i][0] == 1 && visited[i][0] == 0)
            {
                bfs(i,0,n,m,grid,visited);
            }
            if(grid[i][m-1] == 1 && visited[i][m-1] == 0)
            {
                bfs(i,m-1,n,m,grid,visited);
            }
        }
        
        for(int j = 0; j < m; j++)
        {
            if(grid[0][j] == 1 && visited[0][j] == 0)
            {
                bfs(0,j,n,m,grid,visited);
            }
            if(grid[n-1][j] == 1 && visited[n-1][j] == 0)
            {
                bfs(n-1,j,n,m,grid,visited);
            }
        }
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j]==1&&visited[i][j]==0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}