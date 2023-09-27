class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = 0;
        int rigth = m-1;
        int top = 0;
        int bottom = n-1;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(left<=rigth && top <= bottom)
        {
            int temp = 0;
            
            for(int i = left; i <= rigth; i++)
            {
                list.add(matrix[top][i]);
                temp = 1;
            }
            
            if(temp == 1)
            {
                for(int i = top+1; i <=  bottom; i++)
                {
                    list.add(matrix[i][rigth]);
                    temp = 2;
                }
            }
            if(temp == 2)
            {
                for(int i = rigth-1; i >= left; i--)
                {
                    list.add(matrix[bottom][i]);
                    temp = 3;
                }
            }
            if(temp == 3)
            {
                for(int i = bottom-1; i > top; i--)
                {
                    list.add(matrix[i][left]);
                    
                }
            }
            left++;
            rigth--;
            top++;
            bottom--;
        }
        return list;
    }
}