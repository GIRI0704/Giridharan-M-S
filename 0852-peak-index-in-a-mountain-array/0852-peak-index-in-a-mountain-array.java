class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int i = 0;
        int j = arr.length-1;
        
        while(i <= j)
        {
            int mid = (i+j) / 2;
            
            if(mid == 0)
            {
                if(arr[mid] > arr[mid+1]) return mid;
                else i = mid+1;
            }
            else if(mid == arr.length-1)
            {
                if(arr[mid] > arr[mid-1]) return mid;
                else j = mid-1;
            }
            else
            {
                if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) return mid;
                else if(arr[mid] > arr[mid-1]) i = mid+1;
                else j = mid-1;
            } 
        }
        
        return -1;
    }
}