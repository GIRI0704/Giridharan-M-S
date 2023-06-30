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

// using recursion

// class Solution {
//     private List<Integer> list = new ArrayList<>();
    
//     public List<Integer> preorderTraversal(TreeNode root) {
//         tree(root);
//         return list;
//     }
    
//     public List<Integer> tree(TreeNode root)
//     {
//         if(root == null) return list;
//         list.add(root.val);
//         tree(root.left);
//         tree(root.right);
//         return list;
//     }
// }

//using stack

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        
        while(stack.size() > 0)
        {
            TreeNode node = stack.pop();
            list.add(node.val);
            
            if(node.right != null)
            {
                stack.push(node.right);
            }
            if(node.left != null)
            {
                stack.push(node.left);
            }
        }
        
        return list;
    }
}