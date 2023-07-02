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
        if(root == null) return true;
        else
        {
            if(fun(root.left, root.right)) return true;
            else return false;
        }
    }
    public boolean fun(TreeNode left1, TreeNode right1)
	{
		if(left1 ==null || right1 == null) return left1==right1;
		return (left1.val == right1.val) && fun(left1.left,right1.right) && fun(left1.right, right1.left);
	}
}