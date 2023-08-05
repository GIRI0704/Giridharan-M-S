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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
		return fun(root, k, set);
    }
    
    public boolean fun(TreeNode root, int k, HashSet<Integer> set)
	{
		if(root == null) return false;
		int num = root.val;
		if(set.contains(k-num)) return true;
		else set.add(num);
		if(fun(root.left, k, set)) return true;
		if(fun(root.right, k, set)) return true;
		return false;
	}
}