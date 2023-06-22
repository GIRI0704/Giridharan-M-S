//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
        Stack<Character> ch = new Stack<>();
		Stack<Integer> index = new Stack<>();
		index.push(-1);
		int max = 0;
		for(int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);
				if(c == '(')
				{
					ch.push(c);
					index.push(i);
				}
				else
				{
					if(ch.size() > 0 && ch.peek() == '(')
					{
						ch.pop();
						index.pop();
						max = Math.max(max,i-index.peek());
					}
					else
					{
						index.push(i);
					}
				}
			}
		return max;
    }
}