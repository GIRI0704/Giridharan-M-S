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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode head1 = list1;
        
        ListNode head2 = list2;
        ListNode tail2 = list2;
        
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        
        ListNode first = null;
        ListNode second = null;
        
        int index = 0;
        
        while (head1 != null) {
            if (index == a - 1) {
                first = head1;
            }
            if (index == b + 1) {
                second = head1;
            }
            head1 = head1.next;
            index++;
        }
        
        first.next = list2;
        tail2.next = second;
        
        return list1;
    }
}
