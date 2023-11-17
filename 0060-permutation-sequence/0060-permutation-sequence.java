class Solution {
    int x = 0;
    String str = "";
    public String getPermutation(int n, int k) {
        
        String s = "";
        for(int i = 1; i <= n; i++)
        {
            s += i;
        }
        
        k -= 1;
        
        x = k;
        helper(s,"");
        return str;
    }
    
    public void helper(String s, String ans)
    {
        if(s.length() == 0)
        {
            x--;
            if(x == -1)
            {
                str = ans;
            }
            return;
        }
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String rem = s.substring(0,i)+s.substring(i+1);
            helper(rem,ans+ch);
        }
    }
}