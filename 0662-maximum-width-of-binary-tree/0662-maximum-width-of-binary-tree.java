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
class pair
{
    TreeNode node;
    int index;
    pair(TreeNode node, int index)
    {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<pair> q = new ArrayDeque<>();
		int ans = 0;
		q.add(new pair(root, 0));
		while(q.size() > 0)
			{
				int size = q.size();
				int first = 0;
				int last = 0;
				int min = q.peek().index;
				for(int i = 0; i < size; i++)
					{
						int curr = q.peek().index-min;
						TreeNode temp = q.peek().node;
						q.remove();
						if(i == 0) first = curr;
						if(i == size-1) last = curr;
						if(temp.left != null)
						{
							q.add(new pair(temp.left, curr*2+1));
						}
						if(temp.right != null)
						{
							q.add(new pair(temp.right, curr*2+2));
						}
					}
				ans = Math.max(ans, (last-first+1));
			}
		return ans;
        
    }
}