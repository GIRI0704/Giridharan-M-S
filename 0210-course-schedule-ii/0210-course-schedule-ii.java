class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int P = prerequisites.length;
        for(int i = 0; i < N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < P; i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int degree[] = new int[N];
        for(int i = 0; i < N; i++)
        {
            for(int j : adj.get(i))
            {
                degree[j]++;
            }
        }
		int ans[] = new int[N];
		Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++)
        {
            if(degree[i] == 0) q.add(i);
        }
        int count = 0;
		int idx = 0;
        while(q.size() > 0)
        {
            int node = q.remove();
            ans[idx] = node;
			idx++;
            for(int j : adj.get(node))
            {
                degree[j]--;
                if(degree[j] == 0) q.add(j);
            }
        }
		if(idx == N) return ans;
		return new int[0];
    }
}