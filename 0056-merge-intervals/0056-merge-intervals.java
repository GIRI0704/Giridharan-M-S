class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][1];
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int current[] =  intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++)
        {
            int interval[] = intervals[i];
            
            if(current[1] >= interval[0])
            {
                current[1] = Math.max(current[1],interval[1]);
            }
            else
            {
                list.add(current);
                current = interval;
            }
        }
        list.add(current);
        
        return list.toArray(new int[0][1]);
        
    }
}