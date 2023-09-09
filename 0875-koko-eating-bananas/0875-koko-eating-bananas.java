class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int ans  = 0;
        for(int i = 0; i < piles.length; i++)
        {
            max = Math.max(piles[i], max);
        }
        
        int start = 1;
        int end = max;
        
        while(start <= end)
        {
            int mid = (start+end) / 2;
            if(ispossible(piles, h, mid, max))
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] piles, int h, int mid, int max)
    {
        int ans = 0;
        
        for(int i = 0; i < piles.length; i++)
        {
            ans += Math.ceil((double)piles[i]/mid);
        }
        
        if(ans <= h) return true;
        return false;
    }
}