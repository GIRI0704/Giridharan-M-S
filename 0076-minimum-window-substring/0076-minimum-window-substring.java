class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> f2 = new HashMap<>();
        HashMap<Character, Integer> f1 = new HashMap<>();

		for(char ch : t.toCharArray())
			{
				f2.put(ch, f2.getOrDefault(ch, 0)+1);
			}

		int left = 0;
		int right = 0;
        String ans = "";
		int word2 = t.length();
		int word1 = 0;
		while(true)
			{
				boolean l = false;
				boolean r = false;
				if(right < s.length() && word1 < word2)
				{
					r = true;
					char ch = s.charAt(right);
					right++;
					if(f2.containsKey(ch))
					{
						if(f1.getOrDefault(ch, 0) < f2.get(ch))
						{
							word1++;
						}
					}
					f1.put(ch, f1.getOrDefault(ch,0)+1);
					
				}
				else if(left < right && word1 == word2)
				{
					l = true;
					String substring = s.substring(left, right);

					if(ans == "" || ans.length() > substring.length())
					{
						ans = substring;
					}

					char ch = s.charAt(left);

					if(f2.containsKey(ch))
					{
						if(f1.get(ch) <= f2.get(ch))
						{
							word1--;
						}
					}

					f1.put(ch, f1.get(ch)-1);

					if(f1.get(ch) == 0)
					{
						f1.remove(ch);
					}

					left++;
				}
				if(l == false && r == false) break;
			}
		return ans;
    }
}