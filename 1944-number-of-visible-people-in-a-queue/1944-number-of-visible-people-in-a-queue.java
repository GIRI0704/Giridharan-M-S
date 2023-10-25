class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            int ele = heights[i];
            while(stack.size() > 0 && ele >= heights[stack.peek()])
            {
                ans[stack.peek()]++;
                stack.pop();
            }
            if(stack.size() != 0)
            {
                ans[stack.peek()]++;
            }
            stack.push(i);
        }
        return ans;
    }
}