class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
		int presum[] = new int[n];

		presum[0] = nums[0];
		for(int i = 1; i < n; i++)
			{
				presum[i] = nums[i] + presum[i-1];
			}

		for(int i = 0; i < n; i++)
			{
				int a = i-1 < 0 ? 0 : presum[i-1];
				int b = presum[n-1] - presum[i];
				if(a == b) return i;
			}
		return -1;
    }
}