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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return fun(root.left, root.right);
    }
    
    public boolean fun(TreeNode p, TreeNode q)
    {
        if(p == null || q == null) return p == q;
        
        if(p.val != q.val) return false;
        
        boolean left = fun(p.left, q.right);
        if(!left)  return false;
        boolean right = fun(p.right, q.left);
        if(!right)  return false;
        return true;
    }
}