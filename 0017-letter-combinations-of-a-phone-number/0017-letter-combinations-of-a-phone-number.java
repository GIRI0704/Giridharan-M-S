class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        keypad(digits,0,"",result);
        return result;
    }
    public void keypad(String digits, int index, String ans, List<String> result)
    {
        if(ans.length() == digits.length())
        {
            result.add(ans);
            return;
        }
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char ch = digits.charAt(index);
        int num = ch - '0';
        String str = arr[num];
        for(int i = 0; i < str.length(); i++)
        {
            char ch1 = str.charAt(i);
            keypad(digits,index+1,ans+ch1,result);
        }
    }
}