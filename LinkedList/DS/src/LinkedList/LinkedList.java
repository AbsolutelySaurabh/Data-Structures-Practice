package LinkedList;
import java.util.*;

public class LinkedList {
	
	public static Scanner s;
	public static void main(String[] args){
		
	    s = new Scanner(System.in);
		Node head = takeInput();
		printOutput(head);
		
		System.out.println("Enter the position you want to insert at: ");
		int insertPosition = s.nextInt();
		Node newHeadInserted = insertAtIth(head, head, insertPosition, 0);
		System.out.println("LinkedList after insertion: ");
		printOutput(newHeadInserted);
		
		System.out.println("Enter the positions you want to swap the nodes at: ");
		int swap_pos_1 = s.nextInt();
		int swap_pos_2 = s.nextInt();
		Node newHeadSwapped = swapNodes(head, temp, swap_pos_1, swap_pos_2);
		
		System.out.println("Enter the position of the node you want to delete");
		int deletePosition = s.nextInt();
		Node newHeadDeleted = deleteAtIth(head,head, deletePosition, 0);
		System.out.println("LinkedList after deletion: ");
		printOutput(newHeadDeleted);
			
	}
	
	public static void printOutput(Node head){
		
		if(head==null){
			return;
		}
		System.out.println(head.data);
		printOutput(head.next);	
	}
	
	public static Node swapNodes(Node head, Node temp, int swap_pos_1, int swap_pos_2){
		
		for(int i=0;i<swap_pos_1-1;i++){
			
			temp = temp.next;
		}
		
		Node swap_2_temp = head;
		Node swap_2_prev_temp = head;
		
		for(int i=0;i<swap_pos_2;i++){
			swap_2_temp = swap_2_temp.next;
		}
		
		for(int i=0;i<swap_pos_2-1 ;i++){
			
			swap_2_prev_temp = swap_2_prev_temp.next;
		}
		
		Node swap_1_next_temp = temp;
		swap_2_prev_temp.next = temp.next.next;
		temp.next = swap_2_temp;
	
		return head;
	}
	
	public static Node insertAtIth(Node head, Node temp, int i, int prev){
		
		if(head == null || temp == null){
			return head;
		}
		
		if(i==0){
			
			System.out.println("Enter the element you want to insert: ");
			int element = s.nextInt();
			Node node = new Node(element);
			node.next = temp;
			head = node;
			
			return head;
			
		}else{
			
			if(i-1 == prev){
			
				System.out.println("Enter the element you want to insert: ");
				int element = s.nextInt();
				Node node = new Node(element);
				node.next = temp.next;
				temp.next = node;
			
				return head;
				
			}
		}
		
		return insertAtIth(head, temp.next, i, ++prev);
	}
	
	public static Node deleteAtIth(Node head, Node temp, int i, int prev){
		
		if(head == null || temp==null){
			return head;
		}
		
		if(i==0){
			
			head = head.next;
			return head;
		}else{
		
			if(i-1==prev){
				temp.next = temp.next.next;
				return head;
			}
		}
		
		return deleteAtIth(head, temp.next, i, ++prev);
		
	}
	
	public static Node takeInput() {
		
		//takeInput form the useR
		System.out.println("Enter the head: ");
		int n = s.nextInt();
		Node head = null;
	
		while(n!=-1){
			
			Node newNode = new Node(n);
			if(head == null){
				head = newNode;
			}else{
				
				Node temp = head;
				while(temp.next!= null){
					
					temp = temp.next;
				}
				temp.next = newNode;
				
			}
			System.out.println("Enter next element: ");
			n = s.nextInt();	
		}
		return head;
	}

}
