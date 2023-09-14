//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static void dfs(int source, ArrayList<ArrayList<Integer>> adjlist, int visited[])
    {
        visited[source] = 1;
        
        for(int adjnode : adjlist.get(source))
        {
            if(visited[adjnode] == 0)
            {
                dfs(adjnode,adjlist,visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        {
            adjlist.add(new ArrayList<>());
        }
        
        for(int i = 0; i < adj.size(); i++)
        {
            for(int j = 0; j < adj.get(i).size(); j++)
            {
                if(adj.get(i).get(j) == 1)
                {
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        
        int visited[] = new int[V];
        
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            {
                count++;
                dfs(i, adjlist, visited);
            }
        }
        return count;
    }
}