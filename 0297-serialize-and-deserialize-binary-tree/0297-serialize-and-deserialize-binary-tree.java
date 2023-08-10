/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size() > 0)
        {
            TreeNode temp = q.remove();
            if(temp == null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(temp.val+" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String arr[] = data.split(" ");
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i = 1; i < arr.length; i++)
        {
            TreeNode temp = q.remove();
            if(!arr[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = left;
                q.add(left);
            }
            
            if(!arr[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));