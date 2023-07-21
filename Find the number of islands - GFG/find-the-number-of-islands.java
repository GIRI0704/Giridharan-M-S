//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
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
        Queue<pair> q = new ArrayDeque();
        
        q.add(new pair(row, column));
        int n = grid.length;
        int m = grid[0].length;
        
        while(q.size() > 0)
        {
            pair temp = q.remove();
            int row1 = temp.first;
            int column1 = temp.second;
            
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    int nrow = row1 + i;
                    int ncolumn = column1 + j;
                    
                    if(nrow >= 0 && nrow < n && ncolumn >= 0 && ncolumn < m && 
                    visited[nrow][ncolumn] == 0 && grid[nrow][ncolumn] == '1')
                    {
                        visited[nrow][ncolumn] = 1;
                        q.add(new pair(nrow, ncolumn));
                    }
                }
            }
        }
    }
    
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