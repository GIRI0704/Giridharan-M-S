class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int count = 1; // Number of times the current element has been seen
        int j = 1;     // Index to write the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1; // Reset count for the new element
            }

            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
