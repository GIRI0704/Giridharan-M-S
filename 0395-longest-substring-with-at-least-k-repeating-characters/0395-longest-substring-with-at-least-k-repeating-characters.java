class Solution {
    public int longestSubstring(String S, int K) {
        int ans = 0;
		for(int i = 0; i <= 26; i++)
			{
				ans = Math.max(fun(S,K,i),ans);
			}
		return ans;
    }
    public int fun(String s, int k, int x)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int ans =0;
		int unique = 0;
		int uniquek = 0;
		while(end < s.length())
			{   char ch = s.charAt(end);
				map.put(ch, map.getOrDefault(ch,0)+1);
			    if(map.get(ch) == 1) unique++;
				if(map.get(ch) == k) uniquek++;
			     while(unique > x){
						char chstart = s.charAt(start);
						map.put(chstart, map.get(chstart)-1);
						if(map.get(chstart) == 0) unique--;
				        if(map.get(chstart) == k-1) uniquek--;
						start++;
					}
				if(unique == x && uniquek == x){
				ans = Math.max(ans,end-start+1);
			    }
			end++;
			}
		return ans;



	}
}