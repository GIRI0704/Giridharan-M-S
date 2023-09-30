class Solution {
    public String removeOuterParentheses(String s){
        
        StringBuilder result=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
          char c=s.charAt(i);
          if(c=='('){
              count++;
          }  
          else{
              count--;
          }
          temp.append(c);
          if(count==0){
              result.append(temp.substring(1,temp.length()-1));
              temp=new StringBuilder();
          }  
        }
        return result.toString();
    }
}