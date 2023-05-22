class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), list);
        return list;
    }
    public void fun(int arr[], int index, ArrayList<Integer> ans, List<List<Integer>> list)
    {
        if(index == arr.length)
        {
            list.add(new ArrayList<>(ans));
            return;
        }
        fun(arr, index+1, ans, list);
        ans.add(arr[index]);
        fun(arr, index+1, ans, list);
        ans.remove(ans.size()-1);
    }
}