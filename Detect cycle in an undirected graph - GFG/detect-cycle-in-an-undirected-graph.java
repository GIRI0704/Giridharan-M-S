//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to detect cycle in an undirected graph.
   public boolean bfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int source)
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.add(source);

		while(q.size() > 0)
			{
				int current = q.remove();
				if(visited[current]) return true;
				visited[current] = true;

				for(int node : graph.get(current))
					{
						if(!visited[node]) q.add(node);
					}
			}
		return false;
	}
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        boolean visited[] = new boolean[v];

		for(int i = 0; i < v; i++)
			{
				if(visited[i]) continue;
				boolean check = bfs(graph,visited,i);

				if(check) return true;
			}
		return false;
    }
}