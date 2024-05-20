class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int ans = 0;
        if(nums.length == 0) return count;
        for(int num : nums)
        {
            set.add(num);
        }
        
        for(int num : nums)
        {
            if(!set.contains(num-1))
            {
                count = 0;
            while(set.contains(num))
            {
                count++;
                num += 1;
            }
            ans = Math.max(count,ans);
            }
            
        }
        return ans;
    }
}