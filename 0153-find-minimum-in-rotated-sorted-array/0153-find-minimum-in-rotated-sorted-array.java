class Solution {
    public int findMin(int[] arr) {
        
        
        int i = 0; 
		int j = arr.length-1;
        
        if(arr[i] <= arr[j]) return arr[i];

		while(i <= j)
			{
				int mid = (i+j)+1 / 2;

				if(arr[mid] < arr[mid-1])
				{
					return arr[mid];
				}
				else if(arr[i] <= arr[mid])
				{
					i = mid+1;
				}
				else
				{
					j = mid - 1;
				}
			}
		return -1;
    }
}