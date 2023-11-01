/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            // An empty linked list is always considered a subpath.
            return true;
        }
        if (root == null) {
            // If the binary tree is empty and the linked list is not, it's impossible to find a subpath.
            return false;
        }
        
        // Check if the current node's value matches the head of the linked list.
        if (head.val == root.val) {
            // Attempt to find a subpath starting from the current node.
            if (isSubPathFromCurrentNode(head, root)) {
                return true;
            }
        }
        
        // If no subpath was found starting from the current node, continue searching in the left and right subtrees.
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean isSubPathFromCurrentNode(ListNode head, TreeNode root) {
        if (head == null) {
            // The entire linked list has been matched.
            return true;
        }
        if (root == null || head.val != root.val) {
            // The current node's value doesn't match the linked list or the binary tree node is null.
            return false;
        }
        
        // Continue matching the rest of the linked list in the left and right subtrees.
        return isSubPathFromCurrentNode(head.next, root.left) || isSubPathFromCurrentNode(head.next, root.right);
    }
}
