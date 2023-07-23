class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int P = prerequisites.length;
        for(int i = 0; i < N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < P; i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int degree[] = new int[N];
        for(int i = 0; i < N; i++)
        {
            for(int j : adj.get(i))
            {
                degree[j]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++)
        {
            if(degree[i] == 0) q.add(i);
        }
        int count = 0;
        while(q.size() > 0)
        {
            int node = q.remove();
            count++;
            
            for(int j : adj.get(node))
            {
                degree[j]--;
                if(degree[j] == 0) q.add(j);
            }
        }
        
        if(count == degree.length) return true;
        return false;
    }
}