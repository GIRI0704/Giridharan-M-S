class Solution {
    public static int firstIndex(int arr[], int n, int k)
	{
		int i = 0;
		int j = n-1;
		int first = -1;
		while(i <= j)
			{
				int mid = (i+j) / 2;
				if(arr[mid] == k)
				{
					first = mid;
					j = mid-1;
				}
				else if(k > arr[mid])
				{
					i = mid+1;
				}
				else
				{
					j = mid-1;
				}
			}
		return first;
	}

	public static int lastIndex(int arr[], int n, int k)
	{
		int i = 0; 
		int j = n-1;
		int last = -1;

		while(i <= j)
			{
				int mid = (i+j) / 2;
				if(arr[mid] == k)
				{
					last = mid;
					i = mid+1;
				}
				else if(k > arr[mid])
				{
					i = mid+1;
				}
				else j = mid-1;
			}
		return last;
	}
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstIndex(nums,n,target);
		int last = lastIndex(nums,n,target);

		int ans[] = new int[2];
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}