class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int ans[][] = image;
        int color = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1}; 
        dfs(sr,sc,delrow,delcol,image,ans,color,newColor,n,m);
        return ans;
    }
    
    public void dfs(int row, int column,
    int delrow[], int delcol[], int image[][], int ans[][], int color, int newColor, int n, int m)
    {
        ans[row][column] = newColor;
        
        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delrow[i];
            int ncol = column + delcol[i];
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == color &&
            ans[nrow][ncol] != newColor)
            {
                dfs(nrow, ncol, delrow, delcol, image, ans, color, newColor, n ,m);
            }
        }
    }
}