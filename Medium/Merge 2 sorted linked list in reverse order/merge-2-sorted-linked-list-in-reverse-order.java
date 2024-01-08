//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
// Your code here
ArrayList<Integer> al1 = new ArrayList<>();
ArrayList<Integer> al2 = new ArrayList<>();
while(node1 != null){
    al1.add(node1.data);
    node1 = node1.next;
}
 
while(node2 != null){
    al2.add(node2.data);
    node2 = node2.next;
}
 
Node ll = new Node(0);
Node ans = ll;
int i = al1.size()-1;
int j = al2.size()-1;
while(i >= 0 && j >= 0){
    if(al1.get(i) > al2.get(j)){
        Node nn = new Node(al1.get(i));
        i--;
        ll.next = nn;
        ll = ll.next;
    }
    else{
        Node nn = new Node(al2.get(j));
        j--;
        ll.next = nn;
        ll = ll.next;
    }
}
while(i >= 0){
    Node nn = new Node(al1.get(i));
        i--;
        ll.next = nn;
        ll = ll.next;
}
while(j >= 0){
    Node nn = new Node(al2.get(j));
        j--;
        ll.next = nn;
        ll = ll.next;
}
 
return ans.next;
    }
}
