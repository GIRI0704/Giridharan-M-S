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
    public ListNode findsecond(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast!=null && fast.next!=null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
    public ListNode reverse(ListNode second)
    {
        ListNode current = second;
        ListNode next = null;
        ListNode pre = null;
        while(current != null)
        {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode second = findsecond(head);
        ListNode secondhalf = reverse(second);
        ListNode firsthalf = head;
        while(firsthalf!=null)
        {
            if(firsthalf.val != secondhalf.val)
            {
                return false;
            }
            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;
        }
        return true;
    }
}