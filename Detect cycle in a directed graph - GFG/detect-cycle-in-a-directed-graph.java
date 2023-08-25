//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

                                //   dfs
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int i, int V, int path[], int visited[], ArrayList<ArrayList<Integer>> adj)
    {
        visited[i] = 1;
        path[i] = 1;
        
        for(int it : adj.get(i))
        {
            if(visited[it] == 0)
            {
                if(dfs(it,V,path,visited,adj)) return true;
            }
            else if(path[it] == 1) return true;
        }
        path[i] = 0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int visited[] = new int[V];
        int path[] = new int[V];
        
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            {
                if(dfs(i,V,path,visited,adj)) return true;
            }
        }
        return false;
    }
}

                                    //   bfs
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        
        int count = 0;
        while(q.size() > 0)
        {
            int node = q.remove();
            count++;
            
            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        
        if(count == V) return false;
        return true;
    }
}