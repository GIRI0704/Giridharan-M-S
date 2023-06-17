//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] right(int arr[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int right[] = new int[n];
        for(int i = n-1; i >= 0; i--)
        {
            while(stack.size() > 0 && arr[i] > arr[stack.peek()])
            {
                int index = stack.pop();
                right[index] = i;
            }
            
            stack.push(i);
        }
        
        while(stack.size() > 0)
        {
            int index = stack.pop();
            right[index] = -1;
        }
        return right;
    }
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int right[] = right(price, n);
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            ans[i] = i - right[i];
        }
        return ans;
    }
    
}