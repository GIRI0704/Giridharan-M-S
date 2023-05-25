class Solution {
    public int numberOfSteps(int num) {
        int ans = fun(num, 0);
        return ans;
    }
    public int fun(int n, int count)
    {
        if(n == 0) return count;
        if(n%2==0)
        {
           return fun(n/2,count+1);
        }
        else
        {
            return fun(n-1,count+1);
        }
    }
}