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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        s1.push(root);
        
        while(s1.size() > 0)
        {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left != null) s1.push(temp.left);
            if(temp.right != null) s1.push(temp.right);
        }
        
        while(s2.size() > 0)
        {
            list.add(s2.pop().val);
        }
        return list;
    }
}

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root){
//         List<Integer> list = new ArrayList<>();
//         fun(root,list);
//         return list;
//     }
//     public void fun(TreeNode root, List<Integer> list)
//     {
//         if(root == null) return;
//         fun(root.left, list);
//         fun(root.right, list);
//         list.add(root.val);
//     }
// }