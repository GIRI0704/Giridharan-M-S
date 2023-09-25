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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode current = head;
        ListNode headodd = null;
        ListNode headeven = null;
        ListNode tailodd = null;
        ListNode taileven = null;
        int count = 1;
        while(current != null)
        {
            if(count % 2 == 1)
            {
                if(headodd == null)
                {
                    headodd = current;
                    tailodd = current;
                }
                else
                {
                    tailodd.next = current;
                    tailodd = current;
                }
            }
            else
            {
                if(headeven == null)
                {
                    headeven = current;
                    taileven = current;
                }
                else
                {
                    taileven.next = current;
                    taileven = current;
                }
            }
            current = current.next;
            count++;
        }
        tailodd.next = null;
        taileven.next = null;
        tailodd.next = headeven;
        
        return headodd;
        
    }
}