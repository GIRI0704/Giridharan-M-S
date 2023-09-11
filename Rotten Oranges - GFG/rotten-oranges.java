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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class pair
{
    int row;
    int column;
    int time;
    
    pair(int row, int column, int time)
    {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int time = 0;
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int count = 0;
        while(q.size() > 0)
        {
            int row = q.peek().row;
            int col = q.peek().column;
            int t = q.peek().time;
            
            q.remove();
            
            time = Math.max(time,t);
            
            for(int i = 0; i < 4; i++)
            {
                int r = row+delrow[i];
                int c = col+delcol[i];
                
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1)
                {
                    count++;
                    grid[r][c] = 2;
                    q.add(new pair(r,c,t+1));
                }
            }
        }
        
        if(fresh != count) return -1;
        return time;
    }
}