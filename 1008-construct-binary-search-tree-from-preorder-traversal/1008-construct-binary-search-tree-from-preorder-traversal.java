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
    public TreeNode bstFromPreorder(int[] preorder) {
        int index[] = new int[1];
        index[0] = 0;
        return helper(preorder,index,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int preorder[], int index[], int min, int max)
    {
        if(index[0] == preorder.length) return null;
        if(preorder[index[0]] < min || preorder[index[0]] > max) return null;
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = helper(preorder,index,min,root.val-1);
        root.right = helper(preorder,index,root.val+1,max);
        return root;
    }
}