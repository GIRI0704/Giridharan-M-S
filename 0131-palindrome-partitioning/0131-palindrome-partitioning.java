class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        fun(0,s,result,new ArrayList<>());
        return result;
    }
    public void fun(int index, String str, List<List<String>> result, ArrayList<String> ans)
    {
        if(index == str.length())
        {
            result.add(new ArrayList<>(ans));
                return;
        }
        for(int i = index; i < str.length(); i++)
        {
            if(ispalindrome(str,index,i))
            {
                ans.add(str.substring(index,i+1));
                fun(i+1,str,result,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public boolean ispalindrome(String str, int start, int end)
    {
        while(start < end)
        {
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
}