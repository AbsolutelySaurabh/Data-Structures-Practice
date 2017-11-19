package Stacks;
import java.util.*;

public class Stacks {
	
	public static Node head;
	public static int length;
	
	private static Scanner s;
	public static void main(String[] args){
		
	    s = new Scanner(System.in);
		Node<Integer> head = push();
		Node<Integer> tempHead = head;
		printOutput(tempHead);
		
		
	}
	
	public void Stack(){
		
		head=null;
		length = 0;
	}
	
	public static void printOutput(Node head){
		
		if(head == null){
			return;
		}
		System.out.println(head.data);
		printOutput(head.next);
		return;
	}
	
	public static int pop(){
		
		System.out.println("Enter the first element: ");
		int input = s.nextInt();
		if(head == null){
			System.out.println("Stack is empty: ");		
		}
		
		Node<Integer> temp = head;
		int value = temp.data;
		head = head.next;
		temp.next = null;
		temp = null;
		length--;
		return value;
		
		
	}
	
	public static Node<Integer> push(){
		
		System.out.println("Enter the first number: ");
		int input = s.nextInt();
		Node head = null;
		while(input!=-1){
			
			if(head==null){
			
				head = new Node(input);
				
			}else{
				
				Node<Integer> temp = new Node(input);
				temp.next = head;
				head = temp;
				
			}
			length++;
			input = s.nextInt();
		}	
		return head;
	}

}
