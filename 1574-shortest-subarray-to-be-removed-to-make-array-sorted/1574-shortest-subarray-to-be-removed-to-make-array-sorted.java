class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Find the longest non-decreasing prefix
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // The array is already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the longest non-increasing suffix
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Calculate the minimum length to remove
        int result = Math.min(n - left - 1, right);

        // Check for the possibility of removing elements from both sides
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
