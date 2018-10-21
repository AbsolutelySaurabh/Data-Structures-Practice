package practice;
import java.util.*;

class LLnode<T>{
	
	T data;
	LLnode next;
	
	LLnode(T data){
		this.data = data;
		this.next = null;
	}
}

public class LL_insert_i_Recur {
	
	static Scanner s = new Scanner(System.in);
	public static void insertI(LLnode<Integer> head, int i) {
		if(head == null) {
			return;
		}
		
		if(i == 2) {
			System.out.println("Enter data to be inserted: ");
			int data = s.nextInt();
			LLnode<Integer> node = new LLnode<>(data);
			LLnode<Integer> temp = head.next;
			head.next = node;
			node.next = temp;
			return;
		}
		insertI(head.next, i-1);
	}
	
	public static void printLL(LLnode<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.println(head.data);
		printLL(head.next);
	}

	public static void main(String[] args) {
		
		System.out.println("Enter LL data: ");
		int n = s.nextInt();
		LLnode<Integer> head = null, temp_head = null;
		while(n!=-1) {
			if(head == null) {
				head = new LLnode<Integer>(n);
				temp_head = head;
			}else {
				LLnode<Integer> node = new LLnode<Integer>(n);
				temp_head.next = node;
				temp_head = node;	
			}
			n = s.nextInt();
		}
		
		System.out.println("Insert at: ");
		int i = s.nextInt();
		printLL(head);
		insertI(head, i);
		printLL(head);
	}
}
