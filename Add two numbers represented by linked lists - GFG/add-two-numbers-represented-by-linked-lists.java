//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node first)
    {
        Node current = first;
        Node next = null;
        Node pre = null;
        while(current != null)
        {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        first = pre;
        return first;
    }
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        first = reverse(first);
        second = reverse(second);
        int carry = 0;
        Node l1 = first;
        Node l2 = second;
        Node head = null;
        Node tail = null;
        while(l1!=null || l2!=null || carry!=0)
        {
            int sum = 0;
            if(l1!=null)
            {
                sum = sum + l1.data;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                sum = sum + l2.data;
                l2 = l2.next;
            }
            int value = sum + carry;
            int num = value%10;
            carry = value/10;
            Node newnode = new Node(num);
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
        head = reverse(head);
        return head;
    }
}