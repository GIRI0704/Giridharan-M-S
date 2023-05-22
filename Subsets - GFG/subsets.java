//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        fun(A,0,new ArrayList<>(),list);
        Collections.sort(list,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> p,ArrayList<Integer> q)
            {   
                int oneSize = p.size();
                int twoSize = q.size();
                for(int i = 0; i < Math.min(oneSize,twoSize); i++)
                {
                    if(i == oneSize || i == twoSize)
                    return oneSize - twoSize;
                    int elementOne = p.get(i);
                    int elementTwo = q.get(i);
                    if(elementOne == elementTwo)
                       continue;
                    return Integer.compare(elementOne, elementTwo);
                }
                return p.size()-q.size();
            }
        });
                
        return list;
    }
    public static void fun(ArrayList<Integer> a, int index, ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> list)
    {
        if(index == a.size())
        {
            list.add(new ArrayList<>(ans));
            return;
        }
        // ans.add(a.get(index));
        fun(a,index+1,ans,list);
        ans.add(a.get(index));
        // ans.remove(ans.size()-1);
        fun(a,index+1,ans,list);
        ans.remove(ans.size()-1);
    }
}