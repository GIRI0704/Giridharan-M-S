class Solution {
    
    public String code(String word)
    {
        int arr[] = new int[26];
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 26; i++)
        {
            if(arr[i] > 0)
            {
                sb.append((char)('a'+i));
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String word : strs)
        {
            String code = code(word);
             
            if(map.containsKey(code))
            {
                List<String> list = map.get(code);
                list.add(word);
                map.put(code, list);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(code, list);
            }
        }
        
        for(String code : map.keySet())
        {
            List<String> list = map.get(code);
            ans.add(list);
        }
        
        return ans;
    }
}