package practice;

import java.util.Scanner;
import java.util.Vector;
import java.util.Stack;

class StackNode{
	
	int data;
	StackNode next;
	
	public StackNode(int data) {
		this.data = data;
		this.next = null;
	}
}

class CustomStack{
	int min = Integer.MAX_VALUE;
	StackNode head = null;
	int size = 0;
	public void push(int data) {
		StackNode node = new StackNode(data);
		node.next = head;
		head = node;
		
		if(data < min) {
			min = data;
		}
		size++;
	}
	
	public StackNode pop() {
		StackNode temp = head;
		head = head.next;
		temp.next = null;
		size--;
		
		return temp;
	}
	
	public int getMin() {
		return min;
	}
}

public class StackUse {
	
	public static void print(CustomStack s, StackNode head) {
		if(head == null) {
			return;
		}
		System.out.println(head.data);
		print(s, head.next);
	}
	
	public static void reverse(CustomStack s) {
		
		Vector<StackNode> v_node = new Vector<>();
		while(s.size!=0) {
			StackNode node = s.pop();
			v_node.add(node);
		}
		CustomStack s2 = new CustomStack();
		while(v_node.size()!=0) {
			s2.push(v_node.remove(v_node.size()-1).data);
		}
		while(s2.size != 0) {
			s.push(s2.pop().data);
		}
	}
	
	public static Stack<StackNode> reverseCollStack(Stack<StackNode> stack) {
		
		Vector<StackNode> v = new Vector<>();
		while(!stack.isEmpty()) {
			v.add(stack.pop());
		}
		
		Stack<StackNode> stack2 = new Stack<>();
		int index = v.size()-1;
		while(v.size()!=0) {
			stack2.push(v.remove(index));
			index--;
		}
		
		//again put into the first stack;
		while(!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
		return stack;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter stack data");
		int n = s.nextInt();
		CustomStack stack = new CustomStack();
		while(n!=-1) {
			stack.push(n);
			n = s.nextInt();
		}
		
		reverse(stack);
		System.out.println("reversed stack: ");
		print(stack, stack.head);
		
		reverse(stack);
		System.out.println("again reversed stack: ");
		print(stack, stack.head);
		
		
		
		//Do using Collections Java
		System.out.println("Using Java Collections: ");
		
		System.out.println("Enter stack data");
	    n = s.nextInt();
		Stack<StackNode> coll_stack = new Stack<StackNode>();
		while(n!=-1) {
			coll_stack.push(new StackNode(n));
			n = s.nextInt();
		}
		
		coll_stack = reverseCollStack(coll_stack);
		//printing coll_stack
		while(!coll_stack.isEmpty()) {
			System.out.println("coll_stack: " + coll_stack.pop().data);
		}

		s.close();
	}

}
