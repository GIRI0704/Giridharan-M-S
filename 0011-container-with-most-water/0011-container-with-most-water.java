class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = 0;
        while (left < right) {
        // Calculate the current area
        int h = Math.min(height[left], height[right]);
        int w = right - left;
        int currentArea = h * w;

        // Update max water if the current area is larger
        maxWater = Math.max(maxWater, currentArea);

        // Move the pointer pointing to the shorter line
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxWater;
    }
}