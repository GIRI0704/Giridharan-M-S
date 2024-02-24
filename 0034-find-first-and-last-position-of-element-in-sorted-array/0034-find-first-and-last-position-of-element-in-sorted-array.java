class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(nums.length == 0) return ans;
        int left = smaller(nums,target);
        int right = larger(nums,target);
        
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    
    public int smaller(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = (start+end) / 2;
            if(nums[mid]==target)
            {
                ans = mid;
                end = mid-1;
                continue;
            }
                
            if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return ans;
    }
    
    public int larger(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = (start+end) / 2;
            if(nums[mid]==target)
            {
                ans = mid;
                start = mid+1;
                continue;
            }
                
            if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return ans;
    }
}