class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              arr[i][j]=matrix[i][j];
                
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(matrix[i][j]==0){
                  for(int i1=0;i1<m;i1++){
                      arr[i][i1]=0;
                  }
                  for(int i1=0;i1<n;i1++){
                      arr[i1][j]=0;
                  }
              }
              
                
            }
        }
       for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              matrix[i][j]=arr[i][j];
                
            }
        }
    

    }
}