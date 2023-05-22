class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        fun(nums,0, new ArrayList<>(), list);
        return list;
    }
    public void fun(int arr[],int index, ArrayList<Integer> ans, List<List<Integer>> list)
    {
        list.add(new ArrayList<>(ans));
        for(int i = index; i < arr.length; i++)
        {
            if(i > index && arr[i-1] == arr[i]) continue;
            ans.add(arr[i]);
            fun(arr,i+1,ans,list);
            ans.remove(ans.size()-1);
        }
    }
}