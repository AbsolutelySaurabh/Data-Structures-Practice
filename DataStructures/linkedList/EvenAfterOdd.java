package linkedList;

import java.util.Scanner;

public class EvenAfterOdd {	
	
	//The Logic here is;
	//make two linked lists: one for odd and one for even.
	//Then place all the even in the evenList and the odd in the oddLinkedList
	//Then join the two.
	
	public static Node oddHead=null, evenHead=null, oddTail=null, evenTail=null;
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		Node head = LinkedList.takeInput();
		//LinkedList.printOutput(head);
		
	    placeEvenAfterOdd(head);
	   
	    
	    joinEvenOddLL();
	    LinkedList.printOutput(oddHead);
	}
	
	public static void joinEvenOddLL(){
		
		oddTail.next = evenHead;
	}
	
	public static Node placeEvenAfterOdd(Node node){
		
		if(node==null){
			return node;
		}
		
		//as we have defined data as 'T' object so need to parse it
		if((int)node.data %2!=0){
			
			addToOddLL(node);
		}else{
			
			addToEvenLL(node);
		}
		
		return placeEvenAfterOdd(node.next);
	}
	
	public static void addToOddLL(Node head){
		
		if(oddHead==null){
			Node oh = new Node(head.data);
			oddHead = oh;
			oddTail = oddHead;
		}else{
			
			Node oh = new Node(head.data);
			oddTail.next = oh;
			oddTail = oddTail.next;
						
		}		
	}
	
	public static void addToEvenLL(Node head){
		
		if(evenHead==null){
			Node oh = new Node(head.data);
			evenHead = oh;
			evenTail = evenHead;
		}else{
			
			Node oh = new Node(head.data);
			evenTail.next = oh;
			evenTail = evenTail.next;
						
		}	
		
	}
}
