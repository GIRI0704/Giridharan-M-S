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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode ans = null;

        while (current != null && current.next != null) {
            ListNode first = current;
            ListNode second = current.next;
            ListNode temp = current.next.next;

            first.next = temp;
            second.next = first;

            if (prev != null) {
                prev.next = second;
            } else {
                // If prev is null, it means we are at the beginning of the list
                ans = second;
            }

            prev = first;
            current = temp;
        }

        return ans;
    }
}
