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
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long left, long right)
    {
        if(root == null) return true;
        
        if(root.val <= left || root.val >= right) return false;
        boolean left1 = helper( root.left, left, root.val);
        if(!left1) return false;
        boolean right1 = helper(root.right, root.val, right);
        if(!right1) return false;
        return true;
    }
}