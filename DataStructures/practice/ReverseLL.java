package practice;
import java.util.Scanner;

public class ReverseLL {
	
	static int swapped = 0, firstTime = 0;
	static Scanner s = new Scanner(System.in);
	
	public static node<Integer> reverse(node<Integer> old_head, node<Integer> prev, node<Integer> curr) {
		
		if(curr == null) {
			return curr;
		}
		node<Integer> new_head = reverse(old_head, curr, curr.next);	
		if(curr.next == null) {
			new_head = curr;
			old_head.next = null;
		}
		curr.next = prev;
		return new_head;
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
		
		node<Integer> new_head = reverse(head, head, head.next);
		printLL(new_head);
	}
}
