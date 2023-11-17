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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        
        ListNode current = head;
        ListNode prev = null;
        
        // Move current to the left position
        while (index < left) {
            prev = current;
            current = current.next;
            index++;
        }

        ListNode first = prev; // The node before the left position
        ListNode tail = current; // The node at the left position

        // Reverse the nodes from left to right
        while (index <= right) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            index++;
        }

        if (first != null) {
            first.next = prev; // Connect the reversed part to the node before the left position
        } else {
            head = prev; // If left position is the head, update the head of the list
        }

        tail.next = current; // Connect the reversed part to the node after the right position

        return head;
    }
}
