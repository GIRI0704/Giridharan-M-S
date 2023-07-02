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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean flag = true;
        while(q.size() > 0)
        {
            List<Integer> sublist = new ArrayList<>();
            int size = q.size();
            for(int i = 1; i <= size; i++)
            {
                if(q.peek().left != null)
                {
                    q.add(q.peek().left);
                }
                if(q.peek().right != null)
                {
                    q.add(q.peek().right);
                }
                if(flag)
                {
                    sublist.add(q.remove().val);
                }
                else sublist.add(0,q.remove().val);
            }
            if(flag) flag = false;
            else flag = true;
            list.add(sublist);
        }
        return list;
    }
}