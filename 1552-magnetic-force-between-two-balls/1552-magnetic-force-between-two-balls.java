class Solution {
    public int maxDistance(int[] a, int cows) {
        
        Arrays.sort(a);
		int start = Integer.MAX_VALUE;
		int end = a[a.length-1] - a[0];

		for(int i = 0; i < a.length-1; i++)
			{
				int diff = a[i+1] - a[i];
				start = Math.min(diff,start);
			}

		int ans = -1;

		while(start <= end)
			{
				int mid = (start+end) / 2;
				if(ispossible(a,cows,mid))
				{
					ans = mid;
					start = mid+1;
				}
				else end = mid-1;
			}
		return ans;
   
    }
    public static boolean ispossible(int a[], int cows, int limit)
	{
		int NoOfCowspaced = 1;
		int LastCowPlaced = a[0];

		for(int i = 1; i < a.length; i++)
			{
				if(a[i]-LastCowPlaced >= limit)
				{
					NoOfCowspaced++;
					LastCowPlaced = a[i];
				}
			}
		return NoOfCowspaced >= cows;
	}
}