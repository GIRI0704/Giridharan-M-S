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
    public void reorderList(ListNode head) {
        if(head.next==null){
            System.out.print(head.val);
        }
     else{
        ListNode c=head;
		ListNode pre=null;
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null){
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		pre.next=null;
       
		ListNode head1=slow;
        ListNode curr=head1;
		ListNode next=null;
		ListNode prenode=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prenode;
			prenode=curr;
			curr=next;
		}
		head1=prenode;
		ListNode first=new ListNode(0);
		first.next=head1;
		head1=first;
        ListNode headfinal=null;
		ListNode tailfinal=null;
		int count=0;
		while(c!=null){
			int n=0;
			if(count==0 || count%2==0){
				n=c.val;
				count++;
				if(count==0){
					continue;
				}
				else if(count>0){
					
					head1=head1.next;
				}
				
				
			}
			else{
				count++;
				n=head1.val;
				c=c.next;
			}
			
			ListNode newnode=new ListNode(n);
			
			if(headfinal==null){
				headfinal=newnode;
				tailfinal=newnode;
			}
			else{
				tailfinal.next=newnode;
				tailfinal=newnode;
			}
		}
		if(head1.next!=null){
			tailfinal.next=head1.next;
		}
	    headfinal=headfinal.next;
		head.next=headfinal;
        
     }
    }
}