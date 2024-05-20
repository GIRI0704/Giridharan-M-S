class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
        
        for(Integer key : map.keySet())
        {
            Pair pair = new Pair(key,map.get(key));
            pq.add(pair);
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        int result[] = new int[k];
        for(int i = 0; i < k; i++)
        {
            result[i] = pq.poll().num;
        }
        return result;
    }
}

class Pair
{
    int num;
    int freq;
    
    Pair(int num, int freq)
    {
        this.num = num;
        this.freq = freq;
    }
}