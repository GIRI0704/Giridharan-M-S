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
    public TreeNode findparent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start)
    {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode res = new TreeNode();
        while(q.size() > 0)
        {
            TreeNode temp = q.remove();
            if(temp.val == start)
            {
                res = temp;
            }
            if(temp.left != null)
            {
                q.add(temp.left);
                parent.put(temp.left, temp);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
                parent.put(temp.right, temp);
            }
        }
        
        return res;
    }
    public int fun(TreeNode start, HashMap<TreeNode, TreeNode> parent)
    {
        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> set = new HashSet<>();
        
        q.add(start);
        set.add(start);
        int max = 0;
        while(q.size() > 0)
        {
            boolean flag = false;
            int size = q.size();
            while(size-->0)
            {
                TreeNode temp = q.remove();
                
                if(temp.left != null && !set.contains(temp.left))
                {
                    flag = true;
                    q.add(temp.left);
                    set.add(temp.left);
                }
                if(temp.right != null && !set.contains(temp.right))
                {
                    flag = true;
                    q.add(temp.right);
                    set.add(temp.right);
                }
                
                if(parent.containsKey(temp) && !set.contains(parent.get(temp)))
                {
                    flag = true;
                    q.add(parent.get(temp));
                    set.add(parent.get(temp));
                }
            }
            
            if(flag) max++;
        }
        return max;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startnode = findparent(root,parent,start);
        
        int max = fun(startnode,parent);
        return max;
    }
}