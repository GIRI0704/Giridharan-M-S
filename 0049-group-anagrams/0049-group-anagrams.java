class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            String code = generateCode(str);
            if(map.containsKey(code))
            {
                List<String> result = map.get(code);
                result.add(str);
                map.put(code, result);
            }
            else
            {
                List<String> result = new ArrayList<>();
                result.add(str);
                map.put(code,result);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet())
        {
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
        
    }
    public String generateCode(String str)
    {
        int arr[] = new int[26];
        
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            arr[ch-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 0)
            {
                char ch = (char) ('a'+i);
                sb.append(ch);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}