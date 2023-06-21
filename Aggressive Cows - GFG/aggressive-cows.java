//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean ispossible(int a[], int cows, int limit)
	{
		int NoOfCowspaced = 1;
		int LastCowPlaced = a[0];

		for(int i = 1; i < a.length; i++)
			{
				if(a[i]-LastCowPlaced >= limit)
				{
					NoOfCowspaced++;
					LastCowPlaced = a[i];
				}
			}
		return NoOfCowspaced >= cows;
	}
    public static int solve(int n, int cows, int[] a) {
        Arrays.sort(a);
		int start = Integer.MAX_VALUE;
		int end = a[a.length-1] - a[0];

		for(int i = 0; i < a.length-1; i++)
			{
				int diff = a[i+1] - a[i];
				start = Math.min(diff,start);
			}

		int ans = -1;

		while(start <= end)
			{
				int mid = (start+end) / 2;
				if(ispossible(a,cows,mid))
				{
					ans = mid;
					start = mid+1;
				}
				else end = mid-1;
			}
		return ans;
    }
    
    
}