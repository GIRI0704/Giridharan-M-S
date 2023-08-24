//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        int visited[] = new int[V];
        int path[] = new int[V];
        int check[] = new int[V];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,visited,check,path,adj);
            }
        }
        for(int i = 0; i < V; i++)
        {
            if(check[i] == 1) list.add(i);
        }
        return list;
    }
    
    boolean dfs(int i, int visited[],int check[],int path[],List<List<Integer>> adj)
    {
        path[i] = 1;
        visited[i] = 1;
        
        for(int it : adj.get(i))
        {
            if(visited[it] == 0)
            {
                if(dfs(it,visited,check,path,adj)) return true;
            }
            else if(path[it] == 1) return true;
        }
        check[i] = 1;
        path[i] = 0;
        return false;
    }
}
