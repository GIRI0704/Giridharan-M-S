class Solution {
    public boolean ispossible(int candies[], long k, long limit)
    {
        long MaxCandies = 0;
        for(int a : candies)
        {
            if(a >= limit)
            {
                MaxCandies += a/limit;
            }
        }
        return MaxCandies >= k;
    }
    public int maximumCandies(int[] candies, long k) {
        long start = 1;
        long end = 0;
        
        for(int candie : candies)
        {
            end += candie;
        }
        
        int ans = 0;
        
        while(start <= end)
        {
            long mid = (start+end) / 2;
            
            if(ispossible(candies, k, mid))
            {
                ans = (int)mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
}