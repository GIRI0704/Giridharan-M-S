class Solution {
    public int candy(int[] A) {
        int N = A.length;
        int left[] = new int[N];
		int right[] = new int[N];
		left[0] = 1;
		right[N-1] = 1;

		for(int i = 1; i < N; i++)
			{
				if(A[i] > A[i-1])
				{
					left[i] = left[i-1] + 1;
				}
				else
				{
					left[i] = 1;
				}
			}
		for(int i = N-2; i >= 0; i--)
			{
				if(A[i] > A[i+1])
				{
					right[i] = right[i+1] + 1;
				}
				else
				{
					right[i] = 1;
				}
			}

		int ans = 0;
		for(int i = 0; i < N; i++)
			{
				int max = Math.max(left[i], right[i]);
				ans += max;
			}
		return ans;
    }
}