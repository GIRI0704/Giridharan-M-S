class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int result[] = new int[1001];
		for(int trip[] : trips)
			{
				int numOfPassanger = trip[0];
				int start = trip[1];
				int end = trip[2];
				result[start] += numOfPassanger;
				result[end] -= numOfPassanger;
			}
        if(result[0] > capacity) return false;
		for(int i = 1; i < 1001; i++)
			{
				result[i] += result[i-1];
				if(result[i] > capacity) return false;
			}
		return true;
    }
}