class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int start = 1;
        int end = position[position.length-1] - position[0];
        int ans = -1;
        while(start <= end)
        {
            int mid = (start+end) / 2;
            
            if(ispossible(position,m,mid))
            {
                ans = mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    
    public boolean ispossible(int position[], int m, int mid)
    {
        int noofcows = 1;
        int pos = position[0];
        
        for(int i = 1; i < position.length; i++)
        {
            if(position[i]-pos >= mid)
            {
                noofcows++;
                pos = position[i];
            }
        }
        
        return noofcows >= m;
    }
}