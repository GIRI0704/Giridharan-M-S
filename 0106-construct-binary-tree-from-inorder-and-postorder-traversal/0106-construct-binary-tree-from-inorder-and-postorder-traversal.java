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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i],i);
        }
        
        TreeNode root = fun(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    
    public TreeNode fun(int postorder[],int ps,int pe,int inorder[],int is, int ie,HashMap<Integer, Integer> map)
    {
        if(ps > pe || is > ie) return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        
        int inroot = map.get(postorder[pe]);
        int left = inroot-is;
        root.left = fun(postorder,ps,ps+left-1,inorder,is,inroot-1,map);
        root.right = fun(postorder,ps+left,pe-1,inorder,inroot+1,ie,map);
        return root;
    }
}