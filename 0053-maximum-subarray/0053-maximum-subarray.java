class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (end < nums.length) {
            currentSum += nums[end];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
                start = end + 1;
            }

            end++;
        }

        return maxSum;
    }
}