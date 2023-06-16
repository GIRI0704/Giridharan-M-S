class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
		int n = asteroids.length;
		for(int i = 0; i < n; i++)
			{
				if(asteroids[i] > 0)
				{
					stack.push(asteroids[i]);
				}
				else
		        {
			        while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
				    {
					    stack.pop();
				    }
			        if(stack.size() > 0 && stack.peek() > 0 && stack.peek() > Math.abs(asteroids[i]))
			        {
				        continue;
			        }
			        else if(stack.size() > 0 && stack.peek() > 0 && stack.peek() == Math.abs(asteroids[i]))
			        {
				        stack.pop();
			        }
			        else 
			        {
				        stack.push(asteroids[i]);
			        }
		        }
			}

		int ans[] = new int[stack.size()];

		for(int i = stack.size()-1; i >= 0; i--)
			{
				ans[i] = stack.pop();
			}
		return ans;
        
    }
}