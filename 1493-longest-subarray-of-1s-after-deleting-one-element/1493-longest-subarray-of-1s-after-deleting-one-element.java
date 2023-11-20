class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int count = 0; // Change count to 0 initially
        int ans = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                count++;
            }

            while (count > 1) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }
        return ans - 1; // Adjust the result by subtracting 1
    }
}
