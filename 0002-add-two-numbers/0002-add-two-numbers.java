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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;//reverse(l1);
        ListNode b = l2;//reverse(l2);
        
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        
        while(a != null || b != null || carry != 0)
        {
            int sum = 0;
            if(a != null)
            {
                sum += a.val;
                a = a.next;
            }
            if(b != null)
            {
                sum += b.val;
                b = b.next;
            }
            
            int value = sum + carry;
            
            int num = value % 10;
            carry = value / 10;
            
            ListNode newNode = new ListNode(num);
        
            
            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        return head;
    }
    public ListNode reverse(ListNode current)
    {
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
}