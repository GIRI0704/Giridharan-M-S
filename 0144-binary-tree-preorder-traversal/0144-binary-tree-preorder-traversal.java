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
    
    // usin
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size() > 0)
        {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return list;
    }
}


         //using recursion

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         fun(root,list);
//         return list;
//     }
//     public void fun(TreeNode root, List<Integer> list)
//     {
//         if(root == null) return;
//         list.add(root.val);
//         fun(root.left, list);
//         fun(root.right, list);
//     }
// }