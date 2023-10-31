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
class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head;

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (length == 1) return head;
        
        int k = n % length;
        if (k == 0) return head; // No need to rotate if k is zero

        int rotate = length - k;
        current = head;
        ListNode prev = null;
        while (rotate > 0) {
            prev = current;
            current = current.next;
            rotate--;
        }
        
        prev.next = null;
        ListNode newhead = current;
        ListNode temp = null;
        
        while (current != null) {
            temp = current;
            current = current.next;
        }
        
        temp.next = head;
        return newhead;
    }
}
