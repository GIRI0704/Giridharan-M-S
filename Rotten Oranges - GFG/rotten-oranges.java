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


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
		 int m = grid[0].length;
		 int visited[][] = new int[n][m];
		 int freshcount = 0;
		 Queue<pair> q = new ArrayDeque<>();
		 for(int i = 0; i < n; i++)
			 {
				 for(int j = 0; j < m; j++)
					 {
						if(grid[i][j] == 2) 
						{
							q.add(new pair(i,j,0));
							visited[i][j] = 2;
						}
						else if(grid[i][j] == 1) freshcount++;
						else visited[i][j] = 0; 
					 } 
			 }
		 int tm = 0;
		 int count = 0;

		 int delrow[] = {-1,0,1,0};
		 int delcol[] = {0,1,0,-1};
		 while(q.size() > 0)
			 {
				 int r = q.peek().row;
				 int c = q.peek().column;
				 int t = q.peek().time;

				 tm = Math.max(tm, t);
				 q.remove();

				 for(int i = 0; i < 4; i++)
					 {
						 int nrow = r + delrow[i];
						 int ncolumn = c + delcol[i];

						 if(nrow >= 0 && nrow < n && ncolumn >= 0 && ncolumn < m && visited[nrow][ncolumn] != 2
						   && grid[nrow][ncolumn] == 1)
						 {
							 q.add(new pair(nrow, ncolumn, t+1));
							 visited[nrow][ncolumn] = 2;
							 count++;
						 }
					 }
			 }
		 if(count != freshcount) return -1;
		 return tm;
    }
}
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