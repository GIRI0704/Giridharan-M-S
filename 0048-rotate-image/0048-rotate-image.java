public class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        // Transpose the matrix (swap rows with columns)
        for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n ; j++)
					{
						if(i>j)
						{
							int temp = mat[i][j];
							mat[i][j] = mat[j][i];
							mat[j][i] = temp;
						}
					}
			}
        
        for(int i = 0; i < n; i++)
        {
            int left = 0;
            int right = n-1;
            
            while(left <= right)
            {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
