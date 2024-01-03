class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if(map.containsKey(ele - k)) {
                count += map.get(ele - k);
            }
            if(map.containsKey(ele + k)) {
                count += map.get(ele + k);
            }

            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return count;
    }
}

