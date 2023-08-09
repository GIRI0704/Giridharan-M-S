/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void findparent(TreeNode root, HashMap<TreeNode,TreeNode> parent)
    {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0)
        {
            TreeNode temp = q.remove();
            if(temp.left != null)
            {
                parent.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                parent.put(temp.right, temp);
                q.add(temp.right);
            }
            
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        findparent(root,parent);
        
        HashSet<TreeNode> set = new HashSet<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(target);
        set.add(target);
        int count = 0;
        while(q.size() > 0)
        {
            int size = q.size();
            if(count == k) break;
            while(size-->0)
            {
                TreeNode temp = q.remove();
                
                if(temp.left != null && !set.contains(temp.left))
                {
                    q.add(temp.left);
                    set.add(temp.left);
                }
                if(temp.right != null && !set.contains(temp.right))
                {
                    q.add(temp.right);
                    set.add(temp.right);
                }
                
                if(parent.containsKey(temp) && !set.contains(parent.get(temp)))
                {
                    set.add(parent.get(temp));
                    q.add(parent.get(temp));
                }
            }
            count++;
        }
        
        List<Integer> list = new ArrayList<>();
        while(q.size() > 0)
        {
            list.add(q.remove().val);
        }
        return list;
    }
}