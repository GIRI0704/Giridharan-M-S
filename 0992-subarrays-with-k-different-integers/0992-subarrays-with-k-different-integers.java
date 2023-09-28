class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        while (end < nums.length) {
            int num = nums[end];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            end++;
            
            while (frequencyMap.size() > k) {
                int leftNum = nums[start];
                frequencyMap.put(leftNum, frequencyMap.get(leftNum) - 1);
                if (frequencyMap.get(leftNum) == 0) {
                    frequencyMap.remove(leftNum);
                }
                start++;
            }
            
            // The number of subarrays ending at 'end' with at most k distinct integers
            count += end - start;
        }
        
        return count;
    }
}
