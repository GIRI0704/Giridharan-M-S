//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size)
    {
        // your code here
        if(size == 1) return nums[0];
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        int min = n/2;
        int ans = -1;
        for(int i = 1; i < n; i++)
        {
            if(nums[i-1] == nums[i])
            {
                count++;
                if(i == n-1)
                {
                    if(count > min) return nums[i];
                }
            }
            else
            {
                if(count > min)
                {
                    ans = nums[i-1];
                    break;
                }
                else
                {
                    count = 1;
                }
            }
        }
        return ans;
    }
}