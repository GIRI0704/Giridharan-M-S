public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = 0; // Initialize the answer to 0.
        int sum = 0; // Initialize the sum to 0.

        while (end < nums.length) {
            sum += nums[end]; // Add the element at 'end' to the current sum.
            
            while (sum >= target) {
                // If the sum becomes greater than or equal to the target, we have a valid subarray.
                // Calculate the length of the subarray and update 'ans'.
                ans = (ans == 0) ? (end - start + 1) : Math.min(ans, end - start + 1);
                
                // To minimize the length, remove elements from the start of the subarray.
                sum -= nums[start];
                start++;
            }
            
            end++; // Expand the subarray by incrementing 'end'.
        }

        return ans;
    }
}
