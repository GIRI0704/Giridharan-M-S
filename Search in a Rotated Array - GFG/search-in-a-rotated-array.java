//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int arr[], int l, int h, int target)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        
        int i = l;
        int j = h;
        
        while(i <= j)
        {
            int mid = (i+j) / 2;
            
            if(arr[mid] == target) return mid;
            
            if(arr[i] <= arr[mid])
            {
                if(target >= arr[i] && target < arr[mid])
                {
                    j = mid-1;
                }
                else i = mid+1;
            }
            else
            {
                if(target > arr[mid] && target <= arr[j])
                {
                    i = mid+1;
                    
                }
                else j = mid-1;
            }
        }
        
        return -1;
    }
}