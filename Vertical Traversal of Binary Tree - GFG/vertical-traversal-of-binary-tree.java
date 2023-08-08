//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java
// class pair
// {
//     Node root;
//     int level;
//     pair(Node root, int level)
//     {
//         this.root = root;
//         this.level = level;
//     }
// }

// class Solution
// {
//     //Function to find the vertical order traversal of Binary Tree.
//     static void findlevels(Node root, int pos, int left[], int right[])
//     {
//         if(root == null) return;
//         left[0] = Math.min(left[0],pos);
//         right[0] = Math.max(right[0],pos);
//         findlevels(root.left, pos-1, left, right);
//         findlevels(root.right, pos+1, left, right);
//     }
//     static ArrayList <Integer> verticalOrder(Node root)
//     {
//         // add your code here
//         if(root == null) return new ArrayList<>();
        
//         ArrayList<Integer> ans = new ArrayList<>();
        
//         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
//         int left[] = new int[1];
//         int right[] = new int[1];
        
//         findlevels(root,0,left,right);
        
//         int nolevels = right[0]-left[0]+1;
        
//         for(int i = 0; i < nolevels; i++)
//         {
//             list.add(new ArrayList<>());
//         }
//         int start = Math.abs(left[0]);
//         Queue<pair> q = new ArrayDeque<>();
//         q.add(new pair(root,start));
        
//         while(q.size() > 0)
//         {
//             int size = q.size();
//             while(size-->0)
//             {
//                 pair temp = q.remove();
//                 list.get(temp.level).add(temp.root.data);
//                 if(temp.root.left != null) q.add(new pair(temp.root.left,temp.level-1));
//                 if(temp.root.right != null) q.add(new pair(temp.root.right,temp.level+1));
//             }
//         }
        
//         for(int i = 0; i < list.size(); i++)
//         {
//             for(int j = 0; j < list.get(i).size(); j++)
//             {
//                 ans.add(list.get(i).get(j));
//             }
//         }
//         return ans;
        
//     }
// }


class pair{
        Node node;
        int level;
        pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }

class Solution
{
     
  
    static void find (Node root,int pos, int l[], int r[]){
        if(root==null)return;
        l[0]=Math.min(l[0],pos);
        r[0]=Math.max(r[0],pos);
        find(root.left,pos-1,l,r);
        find(root.right,pos+1,l,r);
    } 
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        if(root==null)return new ArrayList<>();
        int arr[]=new int[2];
        
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int l[] = new int[1];
        int r[]= new int[1];
        find(root,0,l,r);
        int nol=r[0]-l[0]+1;
        int st=Math.abs(l[0]);
        for(int i=0;i<nol;i++){
            list.add(new ArrayList<>());
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,st));
        while(q.size()>0){
            int s=q.size();
            while(s-- >0){
                pair p=q.remove();
                list.get(p.level).add(p.node.data);
                if(p.node.left!=null){
                    q.add(new pair(p.node.left,p.level-1));
                }
                if(p.node.right!=null){
                    q.add(new pair(p.node.right,p.level+1));
                }
            }
        }
         ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                ans.add(list.get(i).get(j));
            }
        }
        
        return ans;
    }
}