class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        for(char digit : num.toCharArray())
        {
            while(stack.size() > 0 && k > 0 && digit < stack.peek())
            {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while(k > 0 && stack.size() > 0)
        {
            k--;
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(stack.size() > 0)
        {
            sb.insert(0,stack.pop());
        }
        
        while(sb.length() > 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}