class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int arr[] = new int[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        fun(nums,arr,list,new ArrayList<>());
        return list;
    }
    public void fun(int nums[], int arr[], List<List<Integer>> list, ArrayList<Integer> ans)
    {
        if(ans.size() == nums.length)
        {
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(arr[i] != 1)
            {
                arr[i] = 1;
                ans.add(nums[i]);
                fun(nums,arr,list,ans);
                ans.remove(ans.size()-1);
                arr[i] = 0;
            }
        }
    }
}