//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] A, int N, int B) {
        // code here
        int start = Integer.MIN_VALUE;
		int end = 0;

		for(int pack : A)
			{
				start = Math.max(start,pack);
				end += pack;
			}
		int ans = -1;
		while(start <= end)
			{
				int mid = (start+end) / 2;

				if(ispossible(A,B,mid))
				{
					ans = mid;
					end = mid-1;
				}
				else
				{
					start = mid+1;
				}
			}
		return ans;
    }
    public static boolean ispossible(int A[], int B, long mid)
	{
		int days = 1;
		int Totalpacks = 0;
		for(int pack : A)
			{
				if(Totalpacks + pack <= mid)
				{
					Totalpacks += pack;
				}
				else 
				{
					days++;
					Totalpacks = pack;
				}
			}
		return days <= B;
	}
}