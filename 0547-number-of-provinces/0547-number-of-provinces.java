class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean []vis){
        vis[node]=true;
        for(int key:adj.get(node)){
            if(vis[key]!=true){
                dfs(key,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       int n=isConnected.length;
        int m=isConnected[0].length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(isConnected[i][j]==1){
                   adj.get(i).add(j);
                   adj.get(j).add(i);
               }
           }
       }
        int count=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
}