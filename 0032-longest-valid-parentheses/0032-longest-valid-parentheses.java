class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> ch = new Stack<>();
		Stack<Integer> index = new Stack<>();
		index.push(-1);
		int max = 0;
		for(int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);
				if(c == '(')
				{
					ch.push(c);
					index.push(i);
				}
				else
				{
					if(ch.size() > 0 && ch.peek() == '(')
					{
						ch.pop();
						index.pop();
						max = Math.max(max,i-index.peek());
					}
					else
					{
						index.push(i);
					}
				}
			}
		return max;
    }
}