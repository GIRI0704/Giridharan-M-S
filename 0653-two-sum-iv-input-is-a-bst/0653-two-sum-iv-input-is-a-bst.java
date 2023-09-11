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

class  bst{
    Stack<TreeNode> st=new Stack<>();
    boolean c=true;
   public bst(TreeNode root,boolean c1){
        c=c1;
        push(root);
    }
    public int next(){
        TreeNode temp=st.pop();
        if(c==false){
            push(temp.right);
            
        }
        else{
            push(temp.left);
        }
        return temp.val;
    }
   public void push(TreeNode root ){
        while(root!=null){
            st.push(root);
            if(c==false){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
     if(root==null)return false;
     bst l=new bst(root,false);
     bst r=new bst(root,true);
     int i=l.next();
     int j=r.next();
     while(i<j){
         if(i+j == k){
             return true;
         }
         if(i+j < k){
             i=l.next();
         }
         else{
             j=r.next();
         }
     }
        return false;
    }
}