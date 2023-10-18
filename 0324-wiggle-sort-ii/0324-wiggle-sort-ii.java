class Solution {
    public void wiggleSort(int[] nums) {
        int[] tempArr=Arrays.copyOf(nums,nums.length);
        Arrays.sort(tempArr);
        int t=tempArr.length-1;
        for(int i=0;i<nums.length;i++){
            if(i%2!=0){
                nums[i]=tempArr[t];
                tempArr[t]=-1;
                --t;
            } 
        }
        t=0;
        int k=0;
        for(int i=nums.length-1;i>=0;i--){
            if(i%2==0){
                nums[i]=tempArr[t];
                t++;
            }
        }
    }
}

