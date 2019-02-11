package interviewbit;

import java.util.Scanner;

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList{
	
	static Scanner s = new Scanner(System.in);
	public static Node constructLL(){
		
		System.out.println("Enter data: ");
		Node head = null;
		Node temp = head;;
		int n = s.nextInt();
		while(n!=-1){
			
			if(head ==null){
				head = new Node(n);
				temp = head;
			}else{
				Node t = new Node(n);
				temp.next = t;
				temp = t;
			}
			n = s.nextInt();
		}
		return head;
	}
	
	public static void printLL(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.data + " ");
		printLL(head.next);
	}
	
}

public class ReverseLL {
	static Scanner s = new Scanner(System.in);

	//there is also a recursive solution 
	public static Node new_head_recur = null;
	
	public static Node reverseRecur(Node head){
		
		if(head.next == null){
			new_head_recur = head;
			return head;
		}
		Node temp = reverseRecur(head.next);
		temp.next = head;
		return head;
	}
	
	public static Node reverse(Node head){
		
		Node nextHead = head.next;
		Node anotherNextHead = nextHead;
		head.next = null;
		while(nextHead!=null){
			anotherNextHead = nextHead.next;
			nextHead.next = head;
			head = nextHead;
			nextHead = anotherNextHead;
		}
		//new head
		return head;
	}
	
	static Node pall_head, left;
	public static Boolean checkPallindrome(Node right){
		
		left = pall_head;
		if(right == null){
			return true;
		}
		if(!checkPallindrome(right.next)){
			return false;
		}
		if(left.data!=right.data){
			return false;
		}
		left = left.next;
		return true;
	}

	public static void main(String[] args) {
		
		Node head = LinkedList.constructLL();
//		LinkedList.printLL(head);
//		Node new_head = reverse(head);
//		System.out.println("\nreversed iteratively LL: ");
//		LinkedList.printLL(new_head);
//		System.out.println("\nreversed recursively LL: ");
//		Node new_tail = reverseRecur(new_head);
//		new_tail.next = null;
//		LinkedList.printLL(new_head_recur);
		
		//checkPallindrome()
		pall_head = head;
		if(checkPallindrome(head)){
			System.out.println("Yes: ");
		}else{
			System.out.println("No: ");
		}
		
	}

}
