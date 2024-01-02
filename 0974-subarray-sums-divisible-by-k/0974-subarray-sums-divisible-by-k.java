class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            int reminder = sum % k;
            if(reminder < 0)
            {
                reminder = reminder+k;
            }
            
            if(map.containsKey(reminder))
            {
                count += map.get(reminder);
            }
            map.put(reminder, map.getOrDefault(reminder,0)+1);
        }
        return count;
        
    }
}