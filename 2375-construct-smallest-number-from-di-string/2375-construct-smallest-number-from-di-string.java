class Solution {
    public String smallestNumber(String str) {
        
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        String ans = "";
        for(int i = 0 ;i < str.length(); i++)
        {
            stack.push(num);
            num++;
            if(str.charAt(i) == 'I')
            {
                while(stack.size() > 0)
                {
                    ans = ans + stack.pop();
                }
            }
        }
        
        stack.push(num);
        while(stack.size() > 0)
        {
            ans = ans + stack.pop();
        }
        
        return ans;
    }
}