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
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode pre = null;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        ListNode current = head;

        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        current = head;
        while (length >= k) {
            ListNode groupStart = current;
            ListNode groupPrev = prevGroupTail;

            for (int i = 0; i < k; i++) {
                ListNode temp = current.next;
                current.next = groupPrev.next;
                groupPrev.next = current;
                current = temp;
            }

            prevGroupTail = groupStart;
            prevGroupTail.next = current;
            length -= k;
        }

        return dummy.next;
    }
}
