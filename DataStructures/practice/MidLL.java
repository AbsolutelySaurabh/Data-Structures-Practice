package practice;

import java.util.Scanner;
import java.util.Stack;

public class MidLL {
	
	static Scanner s = new Scanner(System.in);
	
	public static node<Integer> mid(node<Integer> head) {
		
		node<Integer> prev = head, curr = head;
		while(curr!=null) {
			
			//the second one if for handling the even length case
			if(curr.next == null || curr.next.next == null) {
				return prev;
			}
			prev = prev.next;
			curr = curr.next.next;
		}
		return curr;
	}
	
	public static void printLL(node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.println(head.data);
		printLL(head.next);
	}

	public static void main(String[] args) {
		
		System.out.println("Enter LL data: ");
		int n = s.nextInt();
		node<Integer> head = null, temp_head = null;
		while(n!=-1) {
			if(head == null) {
				head = new node<Integer>(n);
				temp_head = head;
			}else {
				node<Integer> node = new node<Integer>(n);
				temp_head.next = node;
				temp_head = node;	
			}
			n = s.nextInt();
		}
		
		System.out.println("mid pount is: " + mid(head).data);
	}
}
