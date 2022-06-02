/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class Node {
    int data;
    Node next;
    
    public Node(){
        data = 0;
        next = null;
    }
    
    public Node(int x) {
        this.data = x;
        next = null;
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Node head = null;
		head = insertBegin(head,10);
		head = insertBegin(head,30);
		head = insertBegin(head,20);
		head = insertBegin(head,50);
		head = insertBegin(head,80);
// 		head = delHead(head);
// 		head = delTail(head);
        head = insertPos(head,5,55);
        System.out.println(search(head,10));
        
		
		printList(head);
	}
	
	public static void printList(Node head) {
	    Node curr = head;
	    
	    if(curr == null){
	        System.out.println("The list is empty");
	        return;
	    }
	    
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
	    } while(curr != null);
	}
	
	public static Node insertBegin(Node head, int x) {
	    
	   // if(head == null)
	    
	    Node temp = new Node(x);
	    temp.next = head;
	    return temp;
	    
	}
	
	public static Node insertEnd(Node head, int x ) {
	    Node temp = new Node(x);
	    
	    if(head == null) {
	        return temp;
	    }
	    
	    Node curr = head;
	    while(curr.next != null)
	        curr = curr.next;
	    
	    curr.next = temp;
	    
	    return head;
	}
	
	public static Node delHead(Node head) {
	    if(head == null)
	        return head;
	        
	    head = head.next;
	    return head;
	}
	
	public static Node delTail(Node head) {
	    if(head == null || head.next == null)
	        return head;
	    
	    Node curr = head;
	    while(curr.next.next != null)
	        curr = curr.next;
	        
	    curr.next = null;
	    return head;
	}
	public static Node insertPos(Node head, int pos, int data ) {
	    
	    Node curr = head;
	    Node temp = new Node(data);
	    
	    if(curr == null)
	        return head;
	    
	    if(pos == 1) {
	        temp.next = head;
	        return temp;
	    }
	    for(int i = 0 ; i < pos - 2; i++ )
	        curr = curr.next;
	    
	    temp.next = curr.next;
	    curr.next = temp;
	    
	    return head;
	}
	
// 	public static int search(Node head, int x) { // iterative soln
// 	    if(head == null)
// 	        return -1;
	    
// 	    Node curr = head;
// 	    for(int i = 1 ; curr != null; i++, curr=curr.next) {
// 	        if(curr.data == x)
// 	            return i;
// 	    }
	    
// 	    return -1;
// 	}
    public static int search(Node head, int x) { // recursive solution
        if( head == null )
            return -1;
        if( head.data == x)
            return 1;
        else {
            int res = search(head.next, x);
            if(res == -1) return -1;
            else return res+1;
        }
    }
}
