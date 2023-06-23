class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums)
        {
            set.add(a);
        }
        int ans = 0;
        
        for(int num : nums)
        {
            if(!set.contains(num-1))
            {
                int currentnum = num;
                int len = 1;
                
                while(set.contains(currentnum+1))
                {
                    currentnum += 1;
                    len += 1;
                }
                
                ans = Math.max(ans, len);
            }
        }
        
        return ans;
        
    }
}