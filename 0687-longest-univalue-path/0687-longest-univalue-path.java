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
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        fun(root);
        return max;
        
    }
    public int fun(TreeNode root)
    {
        if(root == null) return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        
        int leftside = 0;
        int rightside = 0;
        
        if(root.left != null && root.val == root.left.val)
            leftside = left+1;
        if(root.right != null && root.val == root.right.val)
            rightside = right+1;
        max = Math.max(max,leftside+rightside);
        
        return Math.max(leftside,rightside);
    }
}