class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int right = arr[n-1];
        int left = arr[0];
        int i = 1;
        int j = n-2;
        int totalwater = 0;
        while(i <= j)
        {
            if(left <= right)
            {
                int minimumBuilding = left;
                
                if(minimumBuilding > arr[i])
                {
                    long water = minimumBuilding - arr[i];
                    totalwater += water;
                }
                
                left = Math.max(left, arr[i]);
                
                i++;
            }
            else
            {
                int minimumBuilding = right;
                
                if(minimumBuilding > arr[j])
                {
                    long water = minimumBuilding - arr[j];
                    totalwater += water;
                }
                
                right = Math.max(right, arr[j]);
                
                j--;
            }
        }
        return totalwater;
    }
}