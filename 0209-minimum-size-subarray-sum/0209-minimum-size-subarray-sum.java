public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            
            while (sum >= target) {
                if(ans == 0) ans = (end - start + 1);
                else
                {
                    ans = Math.min(ans, end - start + 1);
                }
                sum -= nums[start];
                start++;
            }
            end++; 
        }
        return ans;
    }
}
