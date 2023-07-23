//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < P; i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int degree[] = new int[N];
        for(int i = 0; i < N; i++)
        {
            for(int j : adj.get(i))
            {
                degree[j]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++)
        {
            if(degree[i] == 0) q.add(i);
        }
        int count = 0;
        while(q.size() > 0)
        {
            int node = q.remove();
            count++;
            
            for(int j : adj.get(node))
            {
                degree[j]--;
                if(degree[j] == 0) q.add(j);
            }
        }
        
        if(count == degree.length) return true;
        return false;
    }
    
}