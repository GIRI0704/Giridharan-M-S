class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int s=0;
		int e=0;
		int p=1;
		int ans=0;
		while(e<nums.length){
		   if(nums[s]>=k){
			   s++;
			   e++;
		   }
			else{
				 p=p*nums[e];
		   while(p>=k && p>0 ){
			   p=p/nums[s];
			   s++;
		   }
		   ans=ans+(e-s+1);
		   e++;
		}
		}
		  
		return ans;
    }
}