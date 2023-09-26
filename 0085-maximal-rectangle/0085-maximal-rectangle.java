public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxRectangleArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxRectangleArea = Math.max(maxRectangleArea, largestRectangleArea(heights));
        }
        return maxRectangleArea;
    }

    private int largestRectangleArea(int[] heights) {
        int result = 0;
        int ans = 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < heights.length; i++)
        {
            if(heights[i] == 0) continue;
            
            if(heights[i] < min) min = heights[i];
            if(heights[i] > max) max = heights[i];
        }
        
        if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) return 0;
        
        for(int i = min; i <= max; i++)
        {
            for(int j = 0; j < heights.length; j++)
            {
                if(i <= heights[j])
                {
                    ans += i;
                    result = Math.max(result,ans);
                }
                else
                {
                    ans = 0;
                }
            }
            ans = 0;
        }
        result = Math.max(result,ans);
        return result;
        
    }

}