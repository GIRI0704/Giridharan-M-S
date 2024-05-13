class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int a : arr)
        {
            int rem = a % k;
            if(rem < 0)
            {
                rem += k;
            }
            
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        if(map.containsKey(0) && map.get(0) % 2 == 1) return false;
            
        for(int key  : map.keySet())
        {
            if(key != 0 && !map.get(key).equals(map.get(k-key))) return false;
            
        }
        
        return true;
    }
}