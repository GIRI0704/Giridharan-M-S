//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends






//User function Template for Java
class Solution {

class pair
{
    int first;
    int second;
    
    pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

    public void toposort(int start, ArrayList<ArrayList<pair>> adj, int visited[], Stack<Integer> stack)
    {
        visited[start] = 1;
        
        for(int i = 0; i < adj.get(start).size(); i++)
        {
            int v = adj.get(start).get(i).first;
            if(visited[v] == 0)
            {
                toposort(v,adj,visited,stack);
            }
        }
        stack.push(start);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		for(int i = 0; i < N;i++)
		{
		    ArrayList<pair> list = new ArrayList<>();
		    adj.add(list);
		}
		
		for(int i = 0; i < M; i++)
		{
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new pair(v, wt));
		}
		int visited[] = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++)
		{
		    if(visited[i] == 0)
		    {
		        toposort(i,adj,visited,stack);
		    }
		}
		
		int dist[] = new int[N];
		for(int i = 0; i < N; i++)
		{
		    dist[i] = (int)(1e9);
		}
		
		dist[0] = 0;
		
		while(stack.size() > 0)
		{
		    int node = stack.pop();
		    
		    for(int i = 0; i < adj.get(node).size(); i++)
		    {
		        int v = adj.get(node).get(i).first;
		        int w = adj.get(node).get(i).second;
		        if(dist[node]+w < dist[v])
		          {
		              dist[v] = dist[node]+w;
		          }
		    }
		}
		for(int i = 0; i < N; i++)
		{
		    if(dist[i] == 1e9) dist[i] = -1;
		}
		
		return dist;
	}
}