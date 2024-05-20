class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result[] = new int[2];
        
        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if(map.containsKey(target-num))
            {
                result[0] = map.get(target-num);
                result[1] = i;
            }
            else
            {
                map.put(num,i);
            }
        }
        return result;
    }
}