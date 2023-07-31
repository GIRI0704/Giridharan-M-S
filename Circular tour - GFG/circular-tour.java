//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	    int n = petrol.length;
	    int a = 0;
	    int b = 0;
	    for(int i = 0; i < n; i++)
	    {
	        a += petrol[i];
	        b += distance[i];
	    }
	    
	    if(a < b) return -1;
	    
	    int gas = 0;
	    int ans = -1;
	    for(int i = 0; i < n; i++)
	    {
	        gas += petrol[i];
	        gas -= distance[i];
	        
	        if(gas < 0)
	        {
	            gas = 0;
	            ans = -1;
	        }
	        else if(ans == -1)
	        {
	            ans = i;
	        }
	    }
	    return ans;
	    
    }
}