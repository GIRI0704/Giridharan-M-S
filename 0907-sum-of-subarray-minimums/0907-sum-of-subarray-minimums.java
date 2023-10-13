class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int left[] = left(arr,n);
		int right[] = right(arr,n);

		long ans = 0;
		for(int i = 0; i < n; i++)
			{
				long subb = (long)((i - left[i]) * (right[i] - i));

				long sum = (subb % 1000000007) * (arr[i] % 1000000007);

				ans = (ans + sum) % 1000000007;
			}

		return (int)ans;
    }
    	public int[] left(int arr[], int n)
	{
		Stack<Integer> stack = new Stack<>();
		int left[] = new int[n];
		for(int i = n-1; i >= 0; i--)
			{
				int ele = arr[i];
				while(stack.size() > 0 && ele <= arr[stack.peek()])
					{
						int index = stack.pop();
						left[index] = i; 
					}
				stack.push(i);
			}
		while(stack.size() > 0)
			{
				left[stack.pop()] = -1;
			}
		return left;
	}
	public int[] right(int arr[], int n)
	{
		Stack<Integer> stack = new Stack<>();
		int right[] = new int[n];
		for(int i = 0; i < n; i++)
			{
				int ele = arr[i];
				while(stack.size() > 0 && ele < arr[stack.peek()])
					{
						int index = stack.pop();
						right[index] = i;
						
					}
				stack.push(i);
			}
		while(stack.size() > 0)
			{
				right[stack.pop()] = n;
			}
		return right;
	}
}

