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
    TreeNode root;
    int level;
    pair(TreeNode root, int level)
    {
        this.root = root;
       this.level = level;
  }
 }
class Solution {
    public void findlevels(TreeNode root, int pos, int left[], int right[])
    {
        if(root == null) return;
        left[0] = Math.min(left[0],pos);
        right[0] = Math.max(right[0],pos);
        findlevels(root.left, pos-1, left, right);
        findlevels(root.right, pos+1, left, right);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int left[] = new int[1];
        int right[] = new int[1];

        findlevels(root, 0, left, right);

        int nolevels = right[0] - left[0] + 1;

        for (int i = 0; i < nolevels; i++) {
            list.add(new ArrayList<>());
        }
        int start = Math.abs(left[0]);
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(root, start));

        while (q.size() > 0) {
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            while (size-- > 0) {
                pair temp = q.remove();
                levelMap.putIfAbsent(temp.level, new ArrayList<>());
                levelMap.get(temp.level).add(temp.root.val);
                if (temp.root.left != null) q.add(new pair(temp.root.left, temp.level - 1));
                if (temp.root.right != null) q.add(new pair(temp.root.right, temp.level + 1));
            }
            for (int level : levelMap.keySet()) {
                List<Integer> vals = levelMap.get(level);
                Collections.sort(vals);
                list.get(level).addAll(vals);
            }
        }

        return list;
    }
}