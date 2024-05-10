class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            
            if(set.contains(num))
            {
                list.add(num);
            }
            else
            {
                set.add(num);
            }
        }
        return list;
    }
}