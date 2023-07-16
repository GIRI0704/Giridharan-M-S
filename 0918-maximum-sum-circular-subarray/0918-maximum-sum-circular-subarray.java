class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n = arr.length;
        int maxtrain = 0;
		int maxi = Integer.MIN_VALUE;
		int total = 0;
		for(int i = 0; i < n; i++)
			{
				total += arr[i];
				int newtrain = arr[i];
				int prevtrain = maxtrain + arr[i];
				maxtrain = Math.max(newtrain, prevtrain);
				maxi = Math.max(maxtrain, maxi);
			}
		int mintrain = 0;
		int mini = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			{
				int newtrain = arr[i];
				int prevtrain = mintrain + arr[i];
				mintrain = Math.min(newtrain, prevtrain);
				mini = Math.min(mintrain, mini);
			}
		int wrap = total - mini;
		if(total == mini) return maxi;
		return Math.max(wrap, maxi);
    }
}