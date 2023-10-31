class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i == -1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        int j = nums.length-1;
        while(j>i && nums[j] <= nums[i])
        {
            j--;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums,i+1,nums.length-1);
        
    }
    public void reverse(int nums[],int start,int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}