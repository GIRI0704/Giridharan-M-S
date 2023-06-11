class Solution {
    public String longestCommonPrefix(String[] strs) {
        String temp = strs[0];
        if(temp.length() == 0) return "";
        if(strs == null || strs.length == 0) return "";
        for(int i = 1; i < strs.length; i++)
        {
            String replace = "";
            String s = strs[i];
            if(s.length() == 0) return "";
            
            int a = temp.length();
            
            int b = s.length();
            
            int min = 0;
            
            if(a < b)
            {
                min = a;
            }
            else
            {
                min = b;
            }
            for(int j = 0; j < min; j++)
            {
                if(temp.charAt(j) == s.charAt(j))
                {
                    replace = replace + s.charAt(j);
                }
                else
                    break;
            }
            
            temp = replace;
        }
        
        return temp;
    }
}