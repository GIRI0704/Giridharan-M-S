//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int N, int b)
    {
        // code here
        int i = 0;
		int j = arr.length-1;
        int ans = arr.length;
		while(i <= j)
			{
				int mid = (i+j) / 2;
				if(b == arr[mid]) return mid;
				if(b < arr[mid])
				{
					ans = mid;
					j = mid-1;
				}
				else
				{
					i = mid+1;
				}
			}
		return ans;
    }
}