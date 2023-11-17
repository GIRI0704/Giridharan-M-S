class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch != '*')
            {
                stack.push(ch);
            }
            else if(stack.size() > 0)
            {
                stack.pop();
            }
        }
        String str = "";
        while(stack.size() > 0)
        {
            str = stack.pop() + str;
        }
        return str;
    }
}