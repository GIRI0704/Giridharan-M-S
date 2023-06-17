class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return max(n,nums) - min(n,nums);
    }
    public int[] leftsmall(int arr[], int n)
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
	public int[] rightsmall(int arr[], int n)
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
	public long min(int n, int a[]){
		int left[] = leftsmall(a,n);
		int right[] = rightsmall(a,n);

		long ans = 0l;
		for(int i = 0; i < n; i++)
			{
				long subb = ((i - left[i]) * (right[i] - i));

				long sum = (subb) * (a[i]);

				ans = (ans + sum);
			}

		return ans;
    }
    
    public int[] leftmax(int arr[], int n)
	{
		Stack<Integer> stack = new Stack<>();
		int left[] = new int[n];
		for(int i = n-1; i >= 0; i--)
			{
				int ele = arr[i];
				while(stack.size() > 0 && ele >= arr[stack.peek()])
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
	public int[] rightmax(int arr[], int n)
	{
		Stack<Integer> stack = new Stack<>();
		int right[] = new int[n];
		for(int i = 0; i < n; i++)
			{
				int ele = arr[i];
				while(stack.size() > 0 && ele > arr[stack.peek()])
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
	public long max(int n, int a[]){
		// write code here
		int left[] = leftmax(a,n);
		int right[] = rightmax(a,n);

		long ans = 0l;
		for(int i = 0; i < n; i++)
			{
				long subb = ((i - left[i]) * (right[i] - i));

				long sum = (subb) * (a[i]);

				ans = (ans + sum);
			}

		return ans;
    }
}