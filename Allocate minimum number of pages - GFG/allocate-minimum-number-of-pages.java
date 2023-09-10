//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends




//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]books,int N,int students)
    {
        //Your code here
        if(students > N) return -1;
        int start = 0;
        int end = 0;
        
        for(int page : books)
        {
            start = Math.max(start, page);
            end += page;
        }
        
        int ans = -1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(ispossible(books,students,mid))
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
    public static boolean ispossible(int books[], int students, int limit)
    {
        int NoOfStudent = 1;
        int NoOfPage = 0;
        
        for(int page : books)
        {
            if(page+NoOfPage <= limit) NoOfPage+=page;
            else 
            {
                NoOfStudent++;
                NoOfPage = page;
            }
        }
        
        return NoOfStudent<=students;
    }
}