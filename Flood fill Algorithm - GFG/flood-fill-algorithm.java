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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
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
    
    pair(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
}
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        
        int n = image.length;
        int m = image[0].length;
        
        int initialColor = image[sr][sc];
        
        Queue<pair> q = new ArrayDeque<>();
        
        q.add(new pair(sr,sc));
        
        
        int row[] = {-1,0,1,0};
        int column[] = {0,1,0,-1};
        while(q.size() > 0)
        {
            int r = q.peek().row;
            int c = q.peek().column;
            image[r][c] = newColor;
            q.remove();
            
            for(int i = 0; i < 4; i++)
            {
                int newrow = r+row[i];
                int newcol = c+column[i];
                
                if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m
                && image[newrow][newcol] != newColor && image[newrow][newcol] == initialColor)
                {
                    image[newrow][newcol] = newColor;
                    q.add(new pair(newrow, newcol));
                }
            }
        }
        
        return image;
    }
}