package queues;

import java.util.Scanner;

public class Queues {
	
	public static Node<Integer> head;
	public static Node<Integer> tail;
	public static int length;
	
	public Queues(){
		
		head = null;
		tail = null;
		length = 0;
	}

    public static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		
	    tail = add();
	    
	    Node temp = head;
	    
	    //if input 1, 2, 3, 4
	    //then queue will print 1, 2, 3, 4 only but stack will print reverse as "head" at reverse position
	    printOutput(temp);
		
	}
	
	public static void printOutput(Node temp){
		
		if(temp==null){
			return;
		}
		
		System.out.println(temp.data);
		printOutput(temp.next);
		
	}
	
	public static int remove(){
		
		if(head==null){
			System.out.println("Stack is empty:  ");
			return -1;
		}
		
		int value = tail.data;
		Node temp = tail;
		tail = tail.next;
		temp.next = null;
		temp = null;
		return value;
	
	}
	
	public static Node add(){
		
		//This method will return the address of the last element of the Queue;
		System.out.println("Enter the first element: ");
		int input = s.nextInt();
		while(input!=-1){
			
			if(head == null){
				head = new Node(input);
				tail = head;
			}else{
				
			    Node newNode = new Node(input);
			    tail.next = newNode;
			    tail = newNode;			
			}
			
			length++;
			input = s.nextInt();
		}	
		
		return tail;
	}
}
