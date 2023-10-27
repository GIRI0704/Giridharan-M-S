class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                StringBuilder str=new StringBuilder(s.substring(i,j+1));
                if(str.toString().equals((str.reverse()).toString())){
                    count++;
                }
            }
        }
        return count;
    }
}