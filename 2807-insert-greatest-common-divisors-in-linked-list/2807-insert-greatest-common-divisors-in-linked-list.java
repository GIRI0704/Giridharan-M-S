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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode current = head;
        ListNode front = head.next;
        
        while(front != null && front != current)
        {
            int ans = gcd(current.val,front.val);
            ListNode newnode = new ListNode(ans);
            newnode.next = front;
            current.next = newnode;
            current = front;
            front = front.next;
        }
        return head;
    }
    
    public int gcd(int current , int front)
    {
        int ans = 1;
        int min = Math.min(current,front);
        for(int i = 1; i <= min; i++)
        {
            if(current % i == 0 && front % i == 0)
            {
                ans = i;
            }
        }
        return ans;
    }
}