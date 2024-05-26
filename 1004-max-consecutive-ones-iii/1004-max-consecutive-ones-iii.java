class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int ans = 0;
        
        while(end < nums.length)
        {
            int num = nums[end];
            if(num == 0) count++;
            
            while(count > k)
            {
                if(nums[start] == 0) count--;
                start++;
            }
            
            ans = Math.max(ans,(end-start)+1);
        end++;
        }
        return ans;
    }
}