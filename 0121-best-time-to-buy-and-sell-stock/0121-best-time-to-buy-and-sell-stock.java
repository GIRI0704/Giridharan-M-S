class Solution {
    public int maxProfit(int[] prices) {
        int val = prices[0];
        int ans = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < val)
            {
                val = prices[i];
            }
            else
            {
                ans = Math.max(ans, Math.abs(val-prices[i]));
            }
        }
        
        return ans;
    }
}