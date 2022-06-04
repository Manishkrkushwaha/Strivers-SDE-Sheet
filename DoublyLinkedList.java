/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class Node {
    int data;
    Node next;
    Node prev;
    
    public Node() {
        
    }
    
    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Node head = null;
		head = insertBegin(head, 20);
		head = insertBegin(head, 22);
		head = insertBegin(head, 24);
		head = insertBegin(head, 25);
		head = insertBegin(head, 27);
		head = insertEnd(head, 29);
// 		printList(head);
// 		head = reverseDLL(head);
// 		printList(head);
		head = delHead(head);
		head = delLast(head);
		printList(head);
	}
	
	public static Node delHead(Node head) {
	    
	    if(head == null) return head;
	    else if(head.next == null) return null;
	    
	    head = head.next;
	    head.prev = null;
	    return head;
	}
	
	public static Node delLast(Node head) {
	    Node curr = head;
	    
	    if(head == null || head.next == null) return null;
	    
	    while(curr.next.next != null)
	        curr = curr.next;
	    
	    curr.next.prev = null;
	    curr.next = null;
	    
	    return head;
	}
	
	public static Node reverseDLL(Node head) {
	    Node curr = head;
	    Node temp = null;
	    
	    if(head == null || head.next == null) {
	        return head;
	    }
	    
	    while(curr != null) {
	        temp = curr.prev;
	        curr.prev = curr.next;
	        curr.next = temp;
	        
	        curr = curr.prev;
	    }
	    
	    return temp.prev;
	}
	
	public static Node insertEnd(Node head, int x) {
	    Node temp = new Node(x);
	    
	    if(head == null ) {
	        return temp;
	    }
	    Node curr = head;
	    while(curr.next != null)
	        curr = curr.next;
	        
	    curr.next = temp;
	    temp.prev = curr;
	    
	    return head;
	    
	}
	
	public static Node insertBegin(Node head, int x) {
	    Node temp = new Node(x);
	    
	    temp.next = head;
	    if(head != null) head.prev = temp;
	    
	    return temp;
	}
	
// 	public static Node insertEnd(int head, int x)
	
	public static void printList(Node head) {
	    if(head == null){
	        System.out.println("The list is empty.");
	        return;
	    }
	    
	    while(head != null) {
	        System.out.print(head.data + " ");
	        head = head.next;
	    }
	    System.out.println();
	}
}
