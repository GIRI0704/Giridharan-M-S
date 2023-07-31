class Solution {
    public int minSwaps(String s) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ']') count++;
            else count -= 1;
            max = Math.max(max,count);
        }
        return (max+1) / 2;
    }
}