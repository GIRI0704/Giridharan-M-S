class Solution {
    public int longestConsecutive(int[] nums) {
        //if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        
        for(int num : nums)
        {
            set.add(num);
        }
        
        
        for(int num : nums)
        {
            if(!set.contains(num-1))
            {
                int len = 0;
                int element = num;
                
                while(set.contains(element))
                {
                    element++;
                    len++;
                }
                
                ans = Math.max(len,ans);
            }
        }
        
        return ans;
    }
}