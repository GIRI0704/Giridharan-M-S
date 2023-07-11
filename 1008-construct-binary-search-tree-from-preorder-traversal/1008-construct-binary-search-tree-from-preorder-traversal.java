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
    public int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return counstruct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode counstruct(int arr[], int left, int right)
    {
        if(index == arr.length) return null;
        if(arr[index] < left || arr[index] > right) return null;
        TreeNode node = new TreeNode(arr[index]);
        index++;
        
        node.left = counstruct(arr, left, node.val-1);
        node.right = counstruct(arr, node.val+1, right);
        
        return node;
    }
}