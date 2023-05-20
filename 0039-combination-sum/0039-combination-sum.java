class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        fun(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }
    public void fun(int nums[], int target, int index, List<Integer> ans, List<List<Integer>> list)
    {
        if(target < 0) return;
        if(target == 0)
        {
            list.add(new ArrayList<>(ans));
            return;
        }
        if(index == nums.length) return;
        int a = nums[index];
        ans.add(a);
        fun(nums, target - a, index, ans, list);
        ans.remove(ans.size()-1);
        fun(nums, target, index+1, ans, list);
    }
}