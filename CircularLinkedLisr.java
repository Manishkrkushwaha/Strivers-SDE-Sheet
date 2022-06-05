/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class Node {
    int data;
    Node next;
    
    public Node(int x) {
        data = x;
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
		head = insertBegin(head,20);
		head = insertBegin(head,30);
		head = insertBegin(head,40);
		head = insertBegin(head,50);
		head = insertEnd(head,60);
// 		head = delHead(head);
        head = deleteKth(head, 3);
		
		printList(head);
	
	}
	
	public static Node deleteKth(Node head, int k) {
	    Node temp = head;
	   // temp = temp.next;
	    if(head == null) return null;
	    if(k == 1)
	        return delHead(head);
	    for(int i = 0;  i < k-2 && temp.next != head; i++, temp = temp.next){}
	    
	    
	    temp.next = temp.next.next;
	    
	    return head;
	}
	
	public static Node delHead(Node head) {
	    
	    if(head == null || head.next == head)
	        return null;
	        
	    head.data = head.next.data;
	    head.next = head.next.next;
	    
	    return head;
	}
	
	public static Node insertEnd(Node head, int data) {
	    Node temp = new Node(data);
	    
	    if(head == null) {
	        temp.next = temp;
	        return temp;
	    }
	    
	    temp.next = head.next;
	    head.next = temp;
	    temp.data = head.data;
	    head.data = data;
	    
	    return temp;
	}
	
	public static Node insertBegin(Node head, int data) {
	    Node temp = new Node(data);
	    if(head == null){
	        temp.next = temp;
	        return temp;
	    }
	    
	    temp.next = head.next;
	    head.next = temp;
	    temp.data = head.data;
	    head.data = data;
	    
	    return head;
	}
	
	public static void printList(Node head) {
	    if(head == null){
	        System.out.println("The list is empty.");
	        return;
	    }
	    Node temp = head;
	    do{
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }while(temp != head);
	}
	
}
