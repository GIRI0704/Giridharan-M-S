//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java
//User function Template for Java

class Solution
{
    public ArrayList<Integer> topo( ArrayList<ArrayList<Integer>> adj, int K)
    {
        int degree[] = new int[K];
        
        for(int i = 0; i < K; i++)
        {
            for(int j : adj.get(i))
            {
                degree[j]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < K; i++)
        {
            if(degree[i] == 0) q.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        while(q.size() > 0)
        {
            int node = q.remove();
            list.add(node);
            
            for(int i : adj.get(node))
            {
                degree[i]--;
                if(degree[i] == 0) q.add(i);
            }
        }
        return list;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int min = Math.min(s1.length(), s2.length());
            
            for(int j = 0; j < min; j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        ArrayList<Integer> list = topo(adj, K);
        
        String ans = "";
        
        for(int i = 0; i < list.size(); i++)
        {
            ans = ans + (char)(list.get(i) + 'a');
        }
        return ans;
    }
}