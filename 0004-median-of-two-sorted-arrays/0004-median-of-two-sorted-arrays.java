class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length+nums2.length];
        int temp = 0;
        for(int i = 0; i < nums1.length; i++)
        {
               ans[i] = nums1[i];
               temp++;
        }
        for(int i = 0; i < nums2.length; i++)
        {
            ans[temp] = nums2[i];
            temp++;
        }
        Arrays.sort(ans);
        if(ans.length % 2 == 0)
        {
            int n = ans.length/2;
            int m = n-1;
            return (float)(ans[n]+ans[m])/2;
        }
        else
        {
             int n = (ans.length/2);
            return ans[n];
        }
    }
}