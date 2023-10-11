//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static  boolean ispos(long mid,int A[],int M){
        int st=1;
        int sum=0;
        for(int i:A){
            if((sum+i) <= mid){
                sum+=i;
            }
            else{
                st++;
                sum=i;
            }
        }
        return st<=M;
    }
    static long minTime(int[] A,int n,int k){
        long s=0;
        long e=0;
        for(int i:A){
            s=Math.max(s,i);
            e+=i;
        }
        if(n==1)return A[0];
       // if(k>n)return -1;
        
        long ans=-1;
        while(s<=e){
            long mid=(s+e)/2;
            if(ispos(mid,A,k)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}