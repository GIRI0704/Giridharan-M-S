class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>fre=new HashMap<>();
        for(String str:words){
            fre.put(str,fre.getOrDefault(str,0)+1);
        }
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
            return fre.get(a).equals(fre.get(b))?a.compareTo(b):fre.get(b)-fre.get(a);
        });
        for(String str:fre.keySet()){
            pq.add(str);
        }
        List<String> ans=new ArrayList<>();
        while(k>0 && pq.size()>0){
            ans.add(pq.remove());
            k--;
        }
        return ans;
    }
}