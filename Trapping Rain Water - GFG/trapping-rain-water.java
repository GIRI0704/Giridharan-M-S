//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int right = arr[n-1];
        int left = arr[0];
        int i = 1;
        int j = n-2;
        long totalwater = 0l;
        while(i <= j)
        {
            if(left < right)
            {
                int minimumBuilding = left;
                
                if(minimumBuilding > arr[i])
                {
                    int water = minimumBuilding - arr[i];
                    totalwater += water;
                }
                
                left = Math.max(left, arr[i]);
                
                i++;
            }
            else
            {
                int minimumBuilding = right;
                
                if(minimumBuilding > arr[j])
                {
                    int water = minimumBuilding - arr[j];
                    totalwater += water;
                }
                
                right = Math.max(right, arr[j]);
                
                j--;
            }
        }
        
        return totalwater;
    } 
}


