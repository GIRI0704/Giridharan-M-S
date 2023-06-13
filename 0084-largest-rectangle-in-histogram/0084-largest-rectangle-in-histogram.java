class Solution {
    public int[] right(int arr[], int n)
    {
         int right[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            int ele = arr[i];
            while(stack.size() > 0 && ele < arr[stack.peek()])
            {
                int index = stack.pop();
                right[index] = i;
            }
            stack.push(i);
        }
        while(stack.size() > 0)
        {
            right[stack.pop()] = n;
        }
        
        return right;
    }
    public int[] left(int arr[], int n)
    {
        int left[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            int ele = arr[i];
            while(stack.size() > 0 && ele < arr[stack.peek()])
            {
                int index = stack.pop();
                left[index] = i;
            }
            stack.push(i);
        }
        while(stack.size() > 0)
        {
            left[stack.pop()] = -1;
        }
        
        return left;
    }
    public int largestRectangleArea(int[] arr) {
        
        int right[] = right(arr, arr.length);
        
        int left[] = left(arr, arr.length);
        
        int max = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            int ele = arr[i];
            
            int width = right[i] - left[i] - 1;
            
            int area = ele * width;
            
            max = Math.max(area,max);
        }
        
        return max;
    }
}