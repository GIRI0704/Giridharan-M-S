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
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        ListNode first = null;
        ListNode second = null;

        // Find the length of the linked list
        while (current != null) {
            length++;
            current = current.next;
        }

        // Find the first node to swap
        current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        first = current;

        // Find the second node to swap
        current = head;
        for (int i = 0; i < length - k; i++) {
            current = current.next;
        }
        second = current;

        // Swap the nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
