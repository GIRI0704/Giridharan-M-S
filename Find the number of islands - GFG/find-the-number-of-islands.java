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

class pair
{
    int row;
    int column;
    
    pair(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
}
class Solution {
    // Function to find the number of islands.
    public void bfs(int row, int column, int n, int m, char grid[][], int visited[][])
    {
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(row, column));
        visited[row][column] = 1;
        while(q.size() > 0)
        {
            int r = q.peek().row;
            int c = q.peek().column;
            q.remove();
            
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    int newrow = r + i;
                    int newcol = c + j;
                    
                    if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == '1')
                    {
                        q.add(new pair(newrow,newcol));
                        visited[newrow][newcol] = 1;
                    }
                }
            }
        }
    }
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
                    bfs(i,j,n,m,grid,visited);
                }
            }
        }
        return count;
    }
}