class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        fun(candidates, target, 0, list, new ArrayList<>());
        return list;
    }
    public void fun(int arr[], int target, int index, List<List<Integer>> list, ArrayList<Integer> ans)
    {
        if(target == 0)
        {
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < arr.length; i++)
        {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ans.add(arr[i]);
            fun(arr, target-arr[i], i+1, list, ans);
            ans.remove(ans.size()-1);
        }
    }
}