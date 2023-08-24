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
        
        int indegree[] = new int[N];
        for(int i = 0; i < N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int n = prerequisites.length;
        
        for(int i = 0; i < n; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(a).add(b);
        }
        
        for(int i = 0; i < N; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }
        
        int count = 0;
        
        while(q.size() > 0)
         {
             int node = q.remove();
             count++;
             
             for(int it : adj.get(node))
             {
                 indegree[it]--;
                 if(indegree[it] == 0) q.add(it);
             }
         }
         
         if(count == N) return true;
         return false;
        
    }
    
}