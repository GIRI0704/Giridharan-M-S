class Solution {
    public List<String> commonChars(String[] words) {
        
        int freq[] = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);
        
        for(String s : words) {
            int charFreq[] = new int[26];
            for(char ch : s.toCharArray()) {
                charFreq[ch - 'a']++;
            }
            
            for(int i = 0; i < 26; i++) {
                if(charFreq[i] < freq[i]) {
                    freq[i] = charFreq[i];
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < 26; i++) {
            for(int j = 1; j <= freq[i]; j++) {
                char ch = (char) ('a' + i);
                String s = "" + ch;
                result.add(s);
            }
        }
        return result;
    }
}
