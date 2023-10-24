class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*n-1; i++)
        {
            int ele = nums[i%n];
            
            while(stack.size() > 0 && ele > nums[stack.peek()])
            {
                int index = stack.pop();
                ans[index] = ele;
            }
            if(i < n)
            {
                stack.push(i);
            }
        }
        return ans;
    }
}