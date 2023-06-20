class Solution {
    public int search(int[] a, int target) {
        int i = 0;
		int j = a.length-1;

		while(i <= j)
			{
				int mid = (i+j) / 2;

				if(a[mid] == target) return mid;
				if(a[i] <= a[mid])
				{
					if(target >= a[i] && target < a[mid])
					{
						j = mid-1;
					}
					else
					{
						i = mid+1;
					}
				}
				else
				{
					if(target > a[mid] && target <= a[j])
					{
						i = mid+1;
					}
					else
					{
						j = mid-1;
					}
				}
			}
		return -1;
        
    }
}