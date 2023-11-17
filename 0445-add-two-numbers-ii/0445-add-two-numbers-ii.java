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
        ListNode current1 = reverse(l1);
        ListNode current2 = reverse(l2);
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while(current1 != null || current2 != null || carry == 1)
        {
            int sum = 0;
            if(current1 != null)
            {
                sum+=current1.val;
                current1 = current1.next;
            }
            if(current2 != null)
            {
                sum+=current2.val;
                current2 = current2.next;
            }
            
            int value = sum+carry;
			int num = value%10;
			carry = value/10;
            
            ListNode newnode = new ListNode(num);
            
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
        return reverse(head);
    }
}