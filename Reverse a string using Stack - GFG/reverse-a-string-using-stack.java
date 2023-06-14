//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String s){
        //code here
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            stack.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(stack.size() != 0)
        {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }

}