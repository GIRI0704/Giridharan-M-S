class Solution {
    public int maxSubArray(int[] nums) {
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        while (end < nums.length) {
            currentSum += nums[end];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
            end++;
        }

        return maxSum;
    }
}