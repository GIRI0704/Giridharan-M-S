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
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = new int[1];
		height(root, ans);
		return ans[0];
    }
    public static int height(TreeNode root, int ans[])
	{
		if(root == null) return 0;
		int left = height(root.left, ans);
		int right = height(root.right, ans);
		ans[0] = Math.max(ans[0], left+right);
		return Math.max(left,right)+1;
	}
}