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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode first = lists[0];
        ListNode second = lists[1];
        ListNode ans = merge(first, second);
        for(int i = 2; i < lists.length; i++)
        {
            ans = merge(ans,lists[i]);
        }
        return ans;
    }
    
    public ListNode merge(ListNode a, ListNode b)
    {
        if(a == null) return b;
        if(b == null) return a;
        ListNode current = null;
        
        if(a.val < b.val)
        {
            current = a;
            current.next = merge(a.next,b);
        }
        else
        {
            current = b;
            current.next = merge(a,b.next);
        }
        
        return current;
    }
}