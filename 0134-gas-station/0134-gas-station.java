class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
	    int a = 0;
	    int b = 0;
	    for(int i = 0; i < n; i++)
	    {
	        a += gas[i];
	        b += cost[i];
	    }
	    
	    if(a < b) return -1;
	    
	    int gass = 0;
	    int ans = -1;
	    for(int i = 0; i < n; i++)
	    {
	        gass += gas[i];
	        gass -= cost[i];
	        
	        if(gass < 0)
	        {
	            gass = 0;
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