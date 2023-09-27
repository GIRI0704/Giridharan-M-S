class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1)return nums[0];
        int ans=Integer.MIN_VALUE;
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=min;
                min=max;
                max=temp;
                ans=Math.max(ans,min);
                ans=Math.max(ans,max);
            }
            ans=Math.max(ans,min);
            ans=Math.max(ans,max);
            max=Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);
            ans=Math.max(ans,max);
            ans=Math.max(ans,min);
        }
        return ans;
    }
}