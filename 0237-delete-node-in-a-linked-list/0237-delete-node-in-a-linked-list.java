/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode Node) {
        
        ListNode newnode = Node.next;
        
        Node.val = newnode.val;
        
        Node.next = newnode.next;
        
    }
}