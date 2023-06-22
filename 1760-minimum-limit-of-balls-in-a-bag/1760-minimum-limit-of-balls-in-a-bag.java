class Solution {
    public static boolean ispossible(int arr[], int m, int limit)
	{
		int operation = 0;
		for(int a : arr)
			{
				if(a > limit)
				{
					if(a%limit == 0)
					{
						operation += (a/limit) - 1;
					}
					else operation += (a/limit);
				}
			}
		return operation <= m;
	}
    public int minimumSize(int[] nums, int maxOperations) {
        
        int start = 1;
		int end = 0;
		for(int a : nums)
			{
			end = Math.max(end,a);
			}
     int ans = -1;
	while(start <= end)
	{
		int mid = (start+end) / 2;
		if(ispossible(nums,maxOperations,mid))
		{
			ans = mid;
			end = mid-1;
		}
		else start = mid+1;
	}
		return ans;
        
    }
}