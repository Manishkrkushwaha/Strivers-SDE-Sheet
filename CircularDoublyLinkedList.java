/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Node {
    int data;
    Node next;
    Node prev;
    
    public Node(int x) {
        data = x;
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
		
		head = insertAtHead(head, 10);
		head = insertAtHead(head, 20);
		head = insertAtHead(head, 30);
		head = insertAtHead(head, 40);
		head = insertAtHead(head, 50);
		
		printList(head);
	}
	
	public static Node insertAtHead(Node head, int x) {
	    Node temp = new Node(x);
	    
	    if(head == null) {
	        temp.next = temp;
	        temp.prev = temp;
	        return temp;
	    }
	    
	    temp.prev = head.prev;
	    head.prev.next = temp;
	    head.prev = temp;
	    temp.next = head;
	    
	    return temp;
	}
	
	public static void printList(Node head) {
	    if(head == null){
	        System.out.println("The list is empty");
	        return;
	    }
	    
	    Node temp = head;
	    
	    do {
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }while(temp != head);
	}
}
