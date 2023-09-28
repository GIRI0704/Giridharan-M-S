class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int start = 0;
        int end = 0;
        int temp = 0;
        int count = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        while(end < nums.length)
        {
            if(nums[end] % 2 == 1)
            {
                temp++;
            }
            
            if(temp == k)
            {
                count++;
            }
            
            if(map.containsKey(temp-k))
            {
                count+=map.get(temp-k);
            }
            
            map.put(temp,map.getOrDefault(temp,0)+1);
            end++;
        }
        
        return count;
       
    }
}