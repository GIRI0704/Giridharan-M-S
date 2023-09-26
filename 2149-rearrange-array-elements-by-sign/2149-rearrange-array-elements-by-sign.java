class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new ArrayDeque<>();
        Queue<Integer> negative = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= 0)
            {
                positive.add(nums[i]);
            }
            else negative.add(nums[i]);
        }
        
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(i % 2 == 0 && positive.size() > 0)
            {
                ans[i] = positive.remove();
            }
            else
            {
                ans[i] = negative.remove();
            }
        }
        return ans;
    }
}