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
    public ListNode deleteMiddle(ListNode head) {
        ListNode current = head;
        int count = 0;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        if(count == 1)
        {
            return null;
        }
        current = head;
        count = (count/2)-1;
        while(count != 0)
        {
            count--;
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}