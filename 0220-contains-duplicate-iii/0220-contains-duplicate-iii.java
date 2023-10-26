class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];

            // Find the successor (the smallest number greater than or equal to num)
            Long successor = set.ceiling(num);
            if (successor != null && successor - num <= valueDiff) {
                return true;
            }

            // Find the predecessor (the largest number less than or equal to num)
            Long predecessor = set.floor(num);
            if (predecessor != null && num - predecessor <= valueDiff) {
                return true;
            }

            set.add(num);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}