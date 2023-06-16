//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends

class Queue
{
    Stack<Integer> main = new Stack<Integer>(); 
    Stack<Integer> aux = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
	    // Your code here
	    if(main.size() == 0) return -1;
	    while(main.size() > 0)
	    {
	        aux.push(main.pop());
	    }
	    
	    int ans = aux.pop();
	    
	    while(aux.size() > 0)
	    {
	        main.push(aux.pop());
	    }
	    return ans;
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    // Your code here	
	    main.push(x);
    }
}

