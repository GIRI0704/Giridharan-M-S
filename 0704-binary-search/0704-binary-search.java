class Solution {
    public int search(int[] nums, int target) {
        int ans = fun(nums,target,0);
        return ans;
    }
    public int fun(int nums[], int target, int index)
    {
        if(index == nums.length) return -1;
        if(nums[index] == target) return index;
        return fun(nums,target,index+1);
    }
}