class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length) return -1;
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        for(int i = 0; i < bloomDay.length; i++)
        {
            start = Math.min(bloomDay[i], start);
            end = Math.max(bloomDay[i], end);
        }
        int ans = 0;
        while(start <= end)
        {
            int mid = (start+end) / 2;
            if(ispossible(bloomDay,m,k,mid))
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
    
    public boolean ispossible(int bloomDay[], int m, int k, int mid)
    {
        int count = 0;
        int ans = 0;
        for(int i = 0; i < bloomDay.length; i++)
        {
            if(bloomDay[i] <= mid)
            {
                count++;
            }
            else
            {
                ans += (count / k);
                count = 0;
            }
        }
        ans += (count / k);
        if(ans >= m) return true;
        return false;
    }
}