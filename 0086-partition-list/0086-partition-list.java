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
    public ListNode partition(ListNode head, int x) {
        ListNode newhead1=null;
		ListNode newtail1=null;
		ListNode newhead2=null;
		ListNode newtail2=null;
		ListNode curr=head;
        if(head==null)return null;
        if(head.next==null) return head;
      //if(x==0)return head;
		while(curr!=null){
			ListNode temp=curr;
			if(curr.val< x){
				if(newhead1==null){
					newhead1=temp;
					newtail1=temp;
				}
				else{
					newtail1.next=temp;
					newtail1=temp;
				}
			}
			else if(curr.val>=x){
				if(newhead2==null){
					newhead2=temp;
					newtail2=temp;
				}
				else{
					newtail2.next=temp;
					newtail2=temp;
				}
			}
			curr=curr.next;
			}
        if(newhead1!=null && newhead2!=null){
		newtail2.next=null;
        newtail1.next=newhead2;
            return newhead1;
        }
       else if(newhead1==null)return newhead2;
        else return newhead1;
    }
}