class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjrev = new ArrayList<>();
        int V = graph.length;
        for(int i = 0; i < V; i++)
        {
            adjrev.add(new ArrayList<>());
        }
        int degree[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            for(int j : graph[i])
            {
                adjrev.get(j).add(i);
                degree[i]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++)
        {
            if(degree[i] == 0) q.add(i);
        }
        
        while(q.size() > 0)
        {
            int node = q.remove();
            list.add(node);
            
            for(int i : adjrev.get(node))
            {
                degree[i]--;
                if(degree[i] == 0) q.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
}