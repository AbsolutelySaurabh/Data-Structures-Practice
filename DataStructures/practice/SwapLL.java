package practice;

import java.util.Scanner;

class node<T>{
	T data;
	node next;
	
	node(T data){
		this.data = data;
		this.next = null;
	}
}

public class SwapLL {
	
	static Scanner s = new Scanner(System.in);
	
	public static void find_swap(node<Integer> head, int x, int y) {
		
		//need to manage curr_x, prev_x and curr_y, prev_y
		node<Integer> curr_x = head, curr_y = head;
		node<Integer> prev_x = curr_x, prev_y = curr_y;
		
		if(x == y) {
			return;
		}
		
		while(curr_x!=null && curr_x.data!=x) {
			prev_x = curr_x;
			curr_x = curr_x.next;
		}
		
		while(curr_y!=null && curr_y.data!=y) {
			prev_y = curr_y;
			curr_y = curr_y.next;
		}
		
		node<Integer> temp = curr_x.next;
		prev_x.next = curr_y;
		curr_x.next = curr_y.next;
		curr_y.next = temp;
		prev_y.next = curr_x;
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
		
		//now to enter to swap data
		System.out.println("Enter first data to be swapped: ");
		int first = s.nextInt();
		System.out.println("Enter second data to be swapped: ");
		int second = s.nextInt();
		
		find_swap(head, first, second);
		printLL(head);
	}
}