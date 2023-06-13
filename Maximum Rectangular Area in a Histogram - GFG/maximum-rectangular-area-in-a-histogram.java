//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long[] left(long arr[], int n)
	{
		long left[] = new long[n];

		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1; i >= 0; i--)
			{
				long ele = arr[i];

				while(stack.size() > 0 && ele < arr[stack.peek()])
					{
						int index = stack.pop();

						left[index] = i;
					}

				stack.push(i);
			}
		while(stack.size() > 0)
			{
				left[stack.pop()] = -1;
			}

		return left;
	}

	public static long[] right(long arr[], int n)
	{
		long right[] = new long[n];

		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < n; i++)
			{
				long ele = arr[i];

				while(stack.size() > 0 && ele < arr[stack.peek()])
					{
						int index = stack.pop();

						right[index] = i;
					}
				stack.push(i);
			}

		while(stack.size() > 0)
			{
				right[stack.pop()] = n;
			}

		return right;
	}
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long left[] = left(hist, (int) n);

		  long right[] = right(hist, (int) n);

		  long max = 0l;

		  for(int i = 0; i < (int)n; i++)
			  {
				  long height = hist[i];

				  long width = right[i] - left[i] - 1;

				  long area = height * width;

				  max = Math.max(max,area);
			  }

		  return max;
    }
        
}



