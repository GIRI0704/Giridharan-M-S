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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        
        ListNode current = head;
        
        while(current != null)
        {
            while(dq.size() > 0 && current.val > dq.getLast().val)
            {
                dq.removeLast();
            }
            dq.addLast(current);
            current = current.next;
        }
        
        ListNode headd = null;
        ListNode tail = null;
        
        while(dq.size() > 0)
        {
            if(headd == null)
            {
                headd = dq.getFirst();
                tail = dq.getFirst();
                dq.removeFirst();
            }
            else
            {
                tail.next = dq.getFirst();
                tail = dq.getFirst();
                dq.removeFirst();
            }
        }
        return headd;
        
    }
}