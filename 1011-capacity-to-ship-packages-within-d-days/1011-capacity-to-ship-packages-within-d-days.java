class Solution {
    public boolean ispossible(int weights[], int days, int limit)
    {
        int NoOfDays = 1;
        int TotalWeight = 0;
        
        for(int weight : weights)
        {
            if(TotalWeight+weight <= limit)
            {
                TotalWeight += weight;
            }
            else
            {
                TotalWeight = weight;
                NoOfDays++;
            }
        }
        
        return NoOfDays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        
        for(int weight : weights)
        {
            start = Math.max(start, weight);
            end += weight;
        }
        
        int ans = -1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            
            if(ispossible(weights, days, mid))
            {
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
}