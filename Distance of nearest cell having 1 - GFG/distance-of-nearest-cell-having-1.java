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


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
		int m = grid[0].length;
		int ans [][] = new int[n][m];
		int visited[][] = new int[n][m];
		Queue<pair> q = new ArrayDeque<>();
		for(int i = 0; i < n; i++)
			{
				for(int j =0; j < m; j++)
					{
						if(grid[i][j] == 1)
						{
							q.add(new pair(i,j,0));
						}
					}
			}
		int delrow[] = {-1,0,1,0};
		int delcol[] = {0,1,0,-1};
		while(q.size() > 0)
			{
				int row = q.peek().row;
				int column = q.peek().column;
				int step = q.peek().step;

				q.remove();

				for(int i = 0; i < 4; i++)
					{
						int r = row+delrow[i];
						int c = column+delcol[i];
						if(r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == 0)
						{
							visited[r][c] = 1;
							ans[r][c] = step+1;
							q.add(new pair(r,c,step+1));
						}
					}			
			}
		return ans;
    }
}
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