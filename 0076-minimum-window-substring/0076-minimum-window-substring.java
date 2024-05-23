class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) +1);
        }
        int left=0;
        int n = s.length();
        int len = Integer.MAX_VALUE;
        String res = "";
        HashMap<Character, Integer> currentCharMap = new HashMap<>();
        for(int right = 0 ; right < n ; right++) {
            char ch = s.charAt(right);
            currentCharMap.put(ch, currentCharMap.getOrDefault(ch,0)+1);
            while(sameMap(currentCharMap, charMap)) {
                if((right-left)+1 < len) {
                    len = (right-left)+1;
                    res = s.substring(left, right+1);
                }
                char leftCh = s.charAt(left);
                currentCharMap.put(leftCh, currentCharMap.getOrDefault(leftCh, 0)-1);
                if(currentCharMap.get(leftCh) < 1) {
                    currentCharMap.remove(leftCh);
                }
                left++;
            }
            
        }

        return res;
    }

    public boolean sameMap(HashMap<Character, Integer> currCharMap, HashMap<Character, Integer> charMap) {
            for(Character key :  charMap.keySet()) {
                if( charMap.get(key) > currCharMap.getOrDefault(key, -1)) {
                    return false;
                }
            }
            return true;
    }
}