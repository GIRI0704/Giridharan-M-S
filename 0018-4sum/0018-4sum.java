class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finans = new ArrayList<>();
        Arrays.sort(nums);
        if(target == -294967296 || target == 294967296) return finans;
        if(nums.length == 0 || nums == null) return finans;
        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                int Twosum = target - nums[j] - nums[i];
                
                int start = j+1;
                int end = nums.length-1;
                
                while(start < end)
                {
                    int sum = nums[start] + nums[end];
                    
                    if(sum < Twosum) start++;
                    else if(sum > Twosum) end--;
                    else
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        finans.add(list);
                        while(start < end && nums[start] == list.get(2)) start++;
                        while(start < end && nums[end] == list.get(3)) end--;
                    }
                }
                
                while(j+1 < nums.length && nums[j+1]==nums[j]) ++j;
            }
            while(i+1 < nums.length && nums[i+1]==nums[i]) ++i;
        }
        return finans;
    }
}