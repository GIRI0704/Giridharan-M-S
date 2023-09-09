class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int end = Integer.MIN_VALUE;
        int start = 1;
        
        for(int i = 0; i < nums.length; i++)
        {
            end = Math.max(end, nums[i]);
        }
        int ans = 0;
        while(start <= end)
        {
            int mid = (start+end) / 2;
            
            if(ispossible(nums,threshold,mid))
            {
                ans = mid;
                end = mid - 1;
            }
            else start = mid+1;
        }
        return ans;
    }
    public boolean ispossible(int nums[], int threshold, int mid)
    {
        int ans = 0;
        for(int i = 0; i < nums.length; i++)
        {
            ans += Math.ceil((double)nums[i]/mid);
        }
        if(ans <= threshold) return true;
        return false;
    }
}