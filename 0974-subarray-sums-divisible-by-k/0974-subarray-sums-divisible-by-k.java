class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for(int num : arr)
			{
				sum += num;
				int rem = sum % k;

				if(rem < 0)
				{
					rem += k;
				}
				if(rem == 0) count++;

				if(map.containsKey(rem))
				{
					count += map.get(rem);
				}

				if(map.containsKey(rem))
				{
					map.put(rem, map.get(rem)+1);
				}
				else
					map.put(rem, 1);
			}
		return count;
    }
}