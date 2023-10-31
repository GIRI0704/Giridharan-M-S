/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     class pair{
        TreeNode node;
        int level;
        pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
   
	void find (TreeNode root,int pos, int arr[],int arr1[]){
        if(root==null)return;
        arr[0]=Math.min(arr[0],pos);
        arr1[0]=Math.max(arr1[0],pos);
        find(root.left,pos-1,arr,arr1);
        find(root.right,pos+1,arr,arr1);
    } 

    public List<List<Integer>> verticalTraversal(TreeNode root) {
      
        if(root==null)return new ArrayList<>();
        int arr[]=new int[1];
        int arr1[]=new int[1];
        find(root,0,arr,arr1);
        List<List<Integer>> list=new ArrayList<>();
        int l=arr[0];
        int r=arr1[0];
        int nol=r-l+1;
        int st=-l;
        for(int i=0;i<nol;i++){
            list.add(new ArrayList<>());
        }
      //  PriorityQueue<>((a, b) -> a.row - b.row))
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->{
            return a.node.val-b.node.val;
        });
        
        q.add(new pair(root,st));
        while(q.size()>0){
            int s=q.size();
             List<pair> temp=new ArrayList<>();
        
            while(s-- >0){
               
                pair p=q.remove();
                list.get(p.level).add(p.node.val);
                if(p.node.left!=null){
                    temp.add(new pair(p.node.left,p.level-1));
                }
                if(p.node.right!=null){
                    temp.add(new pair(p.node.right,p.level+1));
                }
            }
            for(pair h:temp){
                q.add(h);
            }
        }
       
        return list;

    }
}