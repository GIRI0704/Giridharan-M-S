class Solution {
    public boolean match(HashMap<Character, Integer> map,HashMap<Character, Integer> current)
    {
        for(char key:map.keySet())
        {
            if(!current.containsKey(key)) return false;
            else
            {
                if(current.get(key) < 1) return false;
            }
        }
        return true;
    }
    public int numberOfSubstrings(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> current = new HashMap<>();
        
        map.put('a',1);
        map.put('b',1);
        map.put('c',1);
        
        int start = 0;
        int end = 0;
        
        int temp = 0;
        int count = 0;
        
        while(end < s.length())
        {
            char ch = s.charAt(end);
            
            current.put(ch,current.getOrDefault(ch,0)+1);
            
            while(match(map,current))
            {
                char ch1 = s.charAt(start);
                current.put(ch1,current.get(ch1)-1);
                start++;
                temp++;
            }
            count += temp;
            end++;
        }
        return count;
    }
}