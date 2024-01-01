class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            
            if(map.containsKey(k-ele))
            {
                count++;
                int freq = map.get(k-ele);
                if(freq == 1)
                    map.remove(k-ele);
                else
                    map.put(k-ele, freq-1);
            }
            else
            {
                map.put(ele, map.getOrDefault(ele,0)+1);
            }
        }
        return count;
        
    }
}