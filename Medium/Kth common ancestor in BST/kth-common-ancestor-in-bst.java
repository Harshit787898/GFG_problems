//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    int LCA(Node root,int x,int y){
        
        if(root==null){
            return -1;
        }
        
        //We search for a mid value as
        //it will be always the first LCA of BST.
        if(x<root.data && y<root.data){
            return LCA(root.left,x,y);
        }
        else if(x>root.data && y>root.data){
            return LCA(root.right,x,y);
        }
        
        return root.data;
        
    }
    
    public int kthCommonAncestor(Node root, int k, int x, int y){
        
        if(k==0){
            return 0;
        }
        
        int lca=LCA(root,x,y);
        
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node curr=q.poll();
            arr.add(curr.data);
            if(curr.data==lca){
                break;
            }
            
            if(curr.left!=null){
                q.add(curr.left);
            }
            else {
                q.add(new Node(-1));
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
            else {
                q.add(new Node(-1));
            }
            
        }
        
        int p=arr.size()-1;
        while(p!=0 && k>1){
            if(p%2==0){
                p=p/2-1;
            }
            else{
                p=p/2;
            }
            
            k--;
            
        }
        
        if(k>1){
            return -1;
        }
        
        return arr.get(p);
        
    }
}