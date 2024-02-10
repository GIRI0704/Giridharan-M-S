class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int arr[] = new int[2];
        int index = 0;
        
        for(int num : nums)
        {
            if(map.containsKey(target-num))
            {
                arr[0] = map.get(target-num);
                arr[1] = index;
                return arr;
            }
            else
            {
                map.put(num,index);
            }
            index++;
        }
        return new int[2];
    }
}