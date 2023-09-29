class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reversed.substring(i))) {
                return reversed.substring(0, i) + s;
            }
        }

        return s;
    }
}