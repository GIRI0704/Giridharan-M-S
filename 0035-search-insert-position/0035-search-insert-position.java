class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        
        int ans = nums.length;
        
        while(i <= j)
        {
            int mid = (i+j) / 2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid])
            {
                ans = mid;
                j = mid-1;
            }
            else i = mid+1;
        }
        
        return ans;
    }
}