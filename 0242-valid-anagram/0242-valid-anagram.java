class Solution {
    public boolean isAnagram(String s, String t) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        char arr1[] = t.toCharArray();
        Arrays.sort(arr1);
        if(arr.length != arr1.length) return false;
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != arr1[i])
            {
                count = 1;
                break;
            }
        }
        if(count == 0) return true;
        else return false;
    }
}