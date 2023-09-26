class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            while(stack.size() > 0 && ele > nums[stack.peek()])
            {
                int index = stack.pop();
                ans[index] = ele;
            }
            stack.push(i);
        }
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            while(stack.size() > 0 && ele > nums[stack.peek()])
            {
                int index = stack.pop();
                ans[index] = ele;
            }
        }
        while(stack.size() > 0)
        {
            ans[stack.pop()] = -1;
        }
        return ans;
        
    }
}