class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0; // Starting index of the longest palindromic substring
        int end = 0;   // Ending index of the longest palindromic substring
        
        for (int i = 0; i < s.length(); i++) {
            // Expand around the center for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Expand around the center for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Take the maximum length between the two types of palindromes
            int maxLength = Math.max(len1, len2);
            
            if (maxLength > end - start) {
                // If the current palindrome is longer than the previously found one
                // Update the start and end indices
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        
        // Extract and return the longest palindromic substring
        return s.substring(start, end + 1);
    }
    // Helper function to expand around the center of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
