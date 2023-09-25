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
     ListNode merge(ListNode x, ListNode y){
       // Write your code here
	if(x == null){
		return y;
	}
	 if(y==null){
		 return x;
	 }
	 ListNode newnode=null;
	 if(x.val<=y.val){
		 newnode=x;
		 newnode.next=merge(x.next,y);
	 }
	 else{
		 newnode=y;
		 newnode.next=merge(x,y.next);
	 }
	 return newnode;
	 
    }
    public ListNode sortList(ListNode head) {
       if (head == null || head.next == null) {
            return head;
        }

        // Split the linked list into two halves
        ListNode middle = findMiddle(head);
        ListNode leftHalf = head;
        ListNode rightHalf = middle.next;
        middle.next = null;

        // Recursively sort both halves
        leftHalf = sortList(leftHalf);
        rightHalf = sortList(rightHalf);

        // Merge the sorted halves
        return merge(leftHalf, rightHalf);
    
          
    }
     private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    
}