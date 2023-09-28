class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26]; // Array to count the occurrences of each character
        int maxCount = 0; // Variable to keep track of the maximum character count in the current window
        int left = 0; // Left pointer of the window
        int maxLength = 0; // Variable to store the maximum length of the substring
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++; // Increment the count of the current character
            maxCount = Math.max(maxCount, charCount[currentChar - 'A']); // Update maxCount
            
            // If the number of characters to be replaced (k) is exceeded, move the left pointer
            while (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--; // Decrement the count of the left character
                left++; // Move the left pointer to the right
            }
            
            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}


// class Solution {
//     public int repeat(HashMap<Character,Integer> map){
//         int count=0;
//         for(char key:map.keySet()){
//             if(map.get(key)>count){
//                 count=map.get(key);
//             }
//         }
//         return count;
//     }
//     public int characterReplacement(String s, int k) {
//         	HashMap<Character,Integer> map=new HashMap<>();
// 		int sp=0;
// 		int ep=0;
// 		int len=-1;
// 		while(ep<s.length()){
// 			char ch=s.charAt(ep);
// 			map.put(ch,map.getOrDefault(ch,0)+1);
// 			int repeat=repeat(map);
// 			while((ep-sp+1)-repeat>k){
// 				char c=s.charAt(sp);
// 				map.put(c,map.get(c)-1);
// 				sp++;
// 			}
// 			len=Math.max(len,ep-sp+1);
// 			ep++;
// 		}
// 		return len;
//     }
// }