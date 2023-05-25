//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String s){
        
        String ans = fun(s,1);
        return ans;
    }
    public String fun(String s, int i)
    {
        if(i == s.length()) return s;
        if(s.charAt(i-1) == s.charAt(i))
        {
            s = s.substring(0,i-1)+s.substring(i);
            return fun(s,i);
        }
        return fun(s,i+1);
    }
}