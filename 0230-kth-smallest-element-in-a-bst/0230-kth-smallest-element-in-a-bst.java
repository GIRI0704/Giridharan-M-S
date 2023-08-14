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
    public int kthSmallest(TreeNode root, int k) {
        int count[] = new int[1];
        count[0] = k;
        int ans[] = new int[1];
        helper(root,count,ans);
        return ans[0];
    }
    
    public void helper(TreeNode root, int count[],int ans[])
    {
        if(root == null) return;
        helper(root.left, count,ans);
        count[0]--;
        if(count[0] == 0)
        {
            ans[0] = root.val;
            return;
        }
        helper(root.right, count, ans);
    }
}