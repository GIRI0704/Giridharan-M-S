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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root.left == null && root.right == null) return root.val;
        q.add(root);
        int ans = 0;
        while(q.size() > 0)
        {
            int count = 0;
            int size = q.size();
            while(size-->0)
            {
                TreeNode temp = q.remove();
                if(count == 0)
                {
                    ans = temp.val;
                    count = 1;
                }
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return ans;
    }
}