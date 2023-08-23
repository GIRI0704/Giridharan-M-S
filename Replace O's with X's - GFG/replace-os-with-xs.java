//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int r, int c, int n, int m,int delrow[],int delcol[], char a[][], int visited[][])
    {
        visited[r][c] = 1;
        
        for(int i = 0; i < 4; i++)
        {
            int row = r+delrow[i];
            int column = c+delcol[i];
            
            if(row >= 0 && row < n && column >= 0 && column < m && a[row][column]=='O' && visited[row][column]==0)
            {
                dfs(row,column,n,m,delrow,delcol,a,visited);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int visited[][] = new int[n][m];
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        
        for(int i = 0; i < n; i++)
        {
            if(a[i][0] == 'O' && visited[i][0] == 0)
            {
                dfs(i,0,n,m,delrow,delcol,a,visited);
            }
            if(a[i][m-1] == 'O' && visited[i][m-1] == 0)
            {
                dfs(i,m-1,n,m,delrow,delcol,a,visited);
            }
        }
        
        for(int j = 0; j < m; j++)
        {
            if(a[0][j] == 'O' && visited[0][j] == 0)
            {
                dfs(0,j,n,m,delrow,delcol,a,visited);
            }
            if(a[n-1][j] == 'O' && visited[n-1][j] == 0)
            {
                dfs(n-1,j,n,m,delrow,delcol,a,visited);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(a[i][j] == 'O' && visited[i][j] == 0)
                {
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}