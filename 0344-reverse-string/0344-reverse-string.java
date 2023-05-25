class Solution {
    public void reverseString(char[] s) {
        fun(s,0,s.length-1);
        
    }
    public void fun(char s[], int i, int j)
    {
        if(i > j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        fun(s,i+1,j-1);
    }
}