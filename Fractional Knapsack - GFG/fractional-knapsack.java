//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr,(a,b)->{
			double pwa = 1.0*(a.value/(1.0*a.weight));
			double pwb = 1.0*(b.value/(1.0*b.weight));
			// return pwb - pwa;//sorting in desc order on the basis of unit price
			return pwa < pwb ? 1 : -1;//fooling java
		});

		double profit = 0.0;

		for(Item i: arr){
			//if i can accomodate the whole item in my bag
			if(W > i.weight){
				profit += i.value;
				W-=i.weight;
			}else{//i can only accomodate partial item
				double unitPriceOfItem = 1.0*(i.value/(1.0*i.weight));
				double profitOfThisItem = unitPriceOfItem * W;
				profit+=profitOfThisItem;
				W=0;//After accomodating this item we are not left with any capacity
				break;
			}
		}
		return profit;
    }
}