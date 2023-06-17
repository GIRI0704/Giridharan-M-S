class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length;
        int ans[] = new int[n-k+1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            if(dq.size() > 0 && dq.getFirst() <= i-k)
				{
					dq.removeFirst();
				}
				while(dq.size() > 0 && arr[i] > arr[dq.getLast()])
					{
						dq.removeLast();
					}
				dq.addLast(i);

				if(i >= k-1)
				{
					ans[index] = arr[dq.getFirst()];
					index++;
				}
        }
        
        return ans;
    }
}