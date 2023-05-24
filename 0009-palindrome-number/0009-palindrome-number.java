class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        int reverse = 0;
        while(temp > 0)
        {
            int lastdigit = temp%10;
            reverse = (reverse * 10) + lastdigit;
            temp /= 10;
        }
        if(x == reverse) return true;
        else return false;
    }
}