//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int visited[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        if(m[0][0] == 1)
        {
            solve(0,0,n,result,"",m,visited);
        }
        return result;
    }
    public static void solve(int i, int j,int n, ArrayList<String> result, String ans, int m[][], int visited[][])
    {
        if(i == n-1 && j == n-1)
        {
            result.add(ans);
            return;
        }
        if(i+1 < n && visited[i+1][j] == 0 && m[i+1][j] == 1)
        {
            visited[i][j] = 1;
            solve(i+1,j,n,result,ans+'D',m,visited);
            visited[i][j] = 0;
        }
        if(j-1 >= 0 && visited[i][j-1] == 0 && m[i][j-1] == 1)
        {
            visited[i][j] = 1;
            solve(i,j-1,n,result,ans+'L',m,visited);
            visited[i][j] = 0;
        }
        if(j+1 < n && visited[i][j+1] == 0 && m[i][j+1] == 1)
        {
            visited[i][j] = 1;
            solve(i,j+1,n,result,ans+'R',m,visited);
            visited[i][j] = 0;
        }
        if(i-1 >= 0 && visited[i-1][j] == 0 && m[i-1][j]== 1)
        {
            visited[i][j] = 1;
            solve(i-1,j,n,result,ans+'U',m,visited);
            visited[i][j] = 0;
        }
    }
}