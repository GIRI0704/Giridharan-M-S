class Solution {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int train = 0;
		int maxi = Integer.MIN_VALUE;
		for(int i = 0;i<n;i++){
			int newTrain = a[i];
			int prevTrain = train + a[i];
			train = Math.max(newTrain,prevTrain);
			maxi = Math.max(maxi,train);
		}
		return maxi;
    }
}