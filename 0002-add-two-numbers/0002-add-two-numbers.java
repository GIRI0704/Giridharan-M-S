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
    public ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        
        ListNode second = l2;
        
        int carry = 0;
        
        ListNode head = null;
        ListNode tail = null;
        
        while(first != null || second != null || carry != 0)
        {
            int sum = 0;
            
            if(first != null)
            {
                sum = sum+first.val;
                first = first.next;
            }
            
            if(second != null)
            {
                sum = sum+second.val;
                second = second.next;
            }
            
            int value = sum + carry;
            
            int lastDigit = value%10;
            
            carry = value / 10;
            
            ListNode newnode = new ListNode(lastDigit);
            
            if(head == null)
            {
                head = newnode;
                tail = newnode;
            }
            else
            {
                tail.next = newnode;
                tail = newnode;
            }
        }
        
        
        
        return head;
    }
}