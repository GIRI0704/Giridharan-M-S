//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class pair
{
    int row;
    int column;
    int step;
    
    pair(int row, int column, int step)
    {
        this.row = row;
        this.column = column;
        this.step = step;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int ans[][] = new int[n][m];
        
        Queue<pair> q = new ArrayDeque<>();
        
        int visited[][] = new int[n][m];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    ans[i][j] = 0;
                    q.add(new pair(i,j,0));
                    visited[i][j] = 1;
                }
                else 
                visited[i][j] = 0;
            }
        }
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        while(q.size() > 0)
        {
            int r = q.peek().row;
            int c = q.peek().column;
            int step = q.peek().step;
            ans[r][c] = step;
            q.remove();
            for(int i = 0; i < 4; i++)
            {
                int row = r + delrow[i];
                int col = c + delcol[i];
                
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 0 && visited[row][col]==0)
                {
                    visited[row][col] = 1;
                    q.add(new pair(row,col,step+1));
                }
            }
        }
        
        return ans;
        
    }
}