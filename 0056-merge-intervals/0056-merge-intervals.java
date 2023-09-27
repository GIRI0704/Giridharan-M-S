class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) {
            return new int[0][1];
        }

        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check if the current interval overlaps with the next one
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // If there is no overlap, add the current interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last merged interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[0][1]);
    }
}
