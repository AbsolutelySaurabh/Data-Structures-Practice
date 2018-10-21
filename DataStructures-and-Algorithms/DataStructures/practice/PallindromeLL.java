package practice;
import java.util.Scanner;
import java.util.Stack;

public class PallindromeLL {
	
	static Scanner s = new Scanner(System.in);
	
	public static Boolean pallindrome(node<Integer> head, node<Integer> tail) {
		
		//using Stack
		
		//This logic has space complexity : O(n) , time complexity = O(n).
		
		//Although, the space complexity can be reduced by using the half-linked-list method.
		
		Stack<Integer> stack = new Stack<>();;
		while(tail!=null) {
			stack.push(tail.data);
			tail = tail.next;
		}
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(head.data!=top) {
				return false;
			}
			head = head.next;
		}
		return true;
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
		
		if(pallindrome(head, head)) {
			System.out.println("Yes, Pallindrome");
		}else {
			System.out.println("No, not a pallindrome.");
		}
	}
}
