class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int min = n/2;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
            }
            if(count > min)
            {
                ans = nums[i];
                break;
            }
            count = 1;
        }
        return ans;
    }
}