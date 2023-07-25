//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    class pair
    {
        String word;
        int step;
        pair(String word, int step)
        {
            this.word = word;
            this.step = step;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < wordList.length; i++)
        {
            set.add(wordList[i]);
        }
        
        set.remove(startWord);
        
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(startWord,1));
        
        while(q.size() > 0)
        {
            String word = q.peek().word;
            int step = q.peek().step;
            q.remove();
            
            if(word.equals(targetWord)) return step;
            
            for(int i = 0; i < word.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    String newword = word.substring(0,i)+ch+word.substring(i+1);
                    
                    if(set.contains(newword))
                    {
                        set.remove(newword);
                        q.add(new pair(newword,step+1));
                    }
                }
            }
        }
        return 0;
    }
}