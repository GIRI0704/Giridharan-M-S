//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int row, int column,int startrow, int startcolumn,
	int[][] grid, int visited[][], StringBuilder sb, int delrow[], int delcol[])
    {
        int n = grid.length;
		int m = grid[0].length;
		
		visited[row][column] = 1;

		int row1 = row - startrow;
		int column1 = column - startcolumn;

		sb.append(row1+":"+column1+";");

		for(int i = 0; i < 4; i++)
			{
				int r = row + delrow[i];
				int c = column + delcol[i];

				if(r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == 1)
				{
					dfs(r,c,startrow,startcolumn,grid,visited,sb,delrow,delcol);
				}
			}
		
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        HashSet<String> set = new HashSet<>();
	  int delrow[] = {-1,0,1,0};
	  int delcol[] = {0,1,0,-1};
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == 0)
                {
					StringBuilder sb = new StringBuilder();
                    dfs(i,j,i,j,grid,visited,sb,delrow,delcol);

					set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
}
