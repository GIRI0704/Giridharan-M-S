class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String arr[] = paragraph.replaceAll("[!?',;.]"," ").split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set =new HashSet<>();
        for(String str : banned)
        {
            
            set.add(str);
        }
        int maxFreq = 0;
        String ans = "";
        for(String str : arr)
        {
            str = str.toLowerCase();
            if((set.size()!=0 && set.contains(str)) || (str.equals("")))
            {
                continue;
            }
        
            map.put(str,map.getOrDefault(str,0)+1);
            if(map.get(str) > maxFreq)
            {
                
                maxFreq = map.get(str);
                ans = str;
            }
        }
        
    
        return ans;
    }
}