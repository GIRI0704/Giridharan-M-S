class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        
        while(left < n-1 && nums[left] <= nums[left+1])
            left++;
        
        if(left == n-1) return 0;
        
        int right = n-1;
        
        while(right > 0 && nums[right-1] <= nums[right])
            right--;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = left; i <= right; i++)
        {
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        
        while(left > 0 && nums[left-1] > min)
            left--;
        
        while(right < n-1 && nums[right+1] < max)
            right++;
        
        return right-left+1;
    }
}