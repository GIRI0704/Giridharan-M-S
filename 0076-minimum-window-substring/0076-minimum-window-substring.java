class Solution {
    public boolean freqcheck(HashMap<Character, Integer> f1, HashMap<Character, Integer> f2)
	{
		for(char key : f2.keySet())
			{
				if(!f1.containsKey(key)) return false;
				if(f1.get(key) < f2.get(key)) return false;
			}
		return true;
	}
    public String minWindow(String s, String t) {
        int left = 0;
		int right = 0;
		int len = Integer.MAX_VALUE;
		String ans = "";

		HashMap<Character, Integer> f2 = new HashMap<>();
		HashMap<Character, Integer> f1 = new HashMap<>();

		for(int i = 0; i < t.length(); i++)
			{
				char ch = t.charAt(i);
				f2.put(ch, f2.getOrDefault(ch,0)+1);
			}

		while(right < s.length())
			{
				char ch = s.charAt(right);
				f1.put(ch, f1.getOrDefault(ch, 0)+1);

				while(freqcheck(f1,f2))
					{
						if(right-left+1 < len)
						{
							len = right-left+1;
							ans = s.substring(left,right+1);
						}

						char currleft = s.charAt(left);
						f1.put(currleft, f1.get(currleft)-1);
						if(f1.get(currleft) == 0)
						{
							f1.remove(currleft);
						}
						left++;
					}
				right++;
			}
		return ans;
    }
}