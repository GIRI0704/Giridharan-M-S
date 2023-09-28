class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        List<Character> list = new ArrayList<>();
        
        for(char key : map.keySet())
        {
            list.add(key);
        }
        
        Collections.sort(list,(a,b)->{
            return map.get(b)-map.get(a);
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++)
        {
            char ch = list.get(i);
            int count = map.get(ch);
            while(count-->0)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}