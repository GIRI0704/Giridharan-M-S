/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meeting = null;
        ListNode newnode = new ListNode(-1);
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                meeting = slow;
                break;
            }
        }
        
        if(meeting == null) return null;
        
        slow = head;
        
        while(slow != meeting)
        {
            meeting = meeting.next;
            slow = slow.next;
        }
        
        return slow;
    }
}