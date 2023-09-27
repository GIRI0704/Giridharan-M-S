class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        while(end < s.length())
        {
            char ch = s.charAt(end);
            while(set.contains(ch) && set.size() > 0)
            {
                char ch1 = s.charAt(start);
                set.remove(ch1);
                start++;
            }
            set.add(ch);
            max = Math.max(max, (end-start)+1);
            end++;
        }
        
        return max;
    }
}