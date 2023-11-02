class Solution {
//     public long countSubarrays(int[] nums, long k) {
//         // int start = 0;
//         // long sum = 0;
//         // long count = 0;
//         // for(int end = 0; end < nums.length; end++)
//         // {
//         //     sum += nums[end];
//         //     while((sum * (end-start+1)) >= k)
//         //     {
//         //         sum -= nums[start];
//         //         start++;
//         //     }
//         //     if((sum * (end-start+1)) < k)
//         //         count+=(end-start+1);
//         // }
//         // return count;
        
//         int s=0;
// 		int e=0;
// 		int sum1=0;
//         int sum2=0;
// 		long ans=0;
// 		while(e<nums.length){
// 		   sum1=sum1+nums[e];
//            sum2=sum1*(e-s+1);
// 		   while(sum2>=k ){
			  
//                sum1=sum1-nums[s];
//                sum2=sum1*(e-s+1);
//          	   s++;
//          }
		   
// 		   ans=ans+(e-s+1);
// 		   e++;
		
// 		}
		  
// 		return ans;
//     }
    public long countSubarrays(int[] nums, long k) {
    int s = 0;
    int e = 0;
    long sum1 = 0;
    long sum2 = 0;
    long ans = 0;
    while (e < nums.length) {
        sum1 = sum1 + nums[e];
        sum2 = sum1 * (e - s + 1);
        while (sum2 >= k) {
            sum1 = sum1 - nums[s];
            sum2 = sum1 * (e - s);
            s++;
        }
        
        ans = ans + (e - s + 1); // Increment ans by (e - s + 1) here.
        e++;
    }
    
    return ans;
}

}
