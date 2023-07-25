class Solution {
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
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < wordList.size(); i++)
        {
            set.add(wordList.get(i));
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