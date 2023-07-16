//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int arr[], int n) {
        
        // Your code here
        int maxtrain = 0;
		int maxi = Integer.MIN_VALUE;
		int total = 0;
		for(int i = 0; i < n; i++)
			{
				total += arr[i];
				int newtrain = arr[i];
				int prevtrain = maxtrain + arr[i];
				maxtrain = Math.max(newtrain, prevtrain);
				maxi = Math.max(maxtrain, maxi);
			}
		int mintrain = 0;
		int mini = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			{
				int newtrain = arr[i];
				int prevtrain = mintrain + arr[i];
				mintrain = Math.min(newtrain, prevtrain);
				mini = Math.min(mintrain, mini);
			}
		int wrap = total - mini;
		if(total == mini) return maxi;
		return Math.max(wrap, maxi);
    }
    
}

