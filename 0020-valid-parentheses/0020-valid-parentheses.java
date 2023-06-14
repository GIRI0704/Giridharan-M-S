class Solution {
    public boolean isValid(String s) {
        
        int n = s.length();
        
        Stack<Character> stack = new Stack<>();

		int i = 0;
		
		while(i < n)
			{
				char ch = s.charAt(i);

				if(ch == '(' || ch == '[' || ch == '{')
				{
					stack.push(ch);
				}
				else
				{
					if(stack.size() == 0)
					{
						// System.out.println("NO");
						return false;
					}

					if((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '['))
					{
						stack.pop();	
					}
					else
					{
						// System.out.println("NO");
							return false;
					}
				}
				i++;
			}
		if(stack.size() > 0)
		{
			// System.out.println("NO");
            return false;
		}
		else
		{
			// System.out.println("YES");
            return true;
		}
    }
}