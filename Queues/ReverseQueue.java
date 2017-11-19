package Queues;
import java.util.*;
public class ReverseQueue {
	
	//We'll reverse Q using a stack
	
	public static Scanner s;
	public static void main(String[] args){
		
		s = new Scanner(System.in);
		
		Queue q = new LinkedList();
		Stack<Integer> stack = new Stack();

		takeInput(q);
		
		reverseQ(q, stack);
		
		printQueue(q, q.size());
				
	}
	
	public static void printQueue(Queue q, int count){
		
		if(count == 0){
			return;
		}
		
		System.out.println(q.remove());
		printQueue(q, --count);
	}
	
	public static void reverseQ(Queue q, Stack s){
				
		if(q.size() == 0){
			popStackInQueue(q, s);
			return;
		}
		
		s.push(q.remove());
		reverseQ(q, s);
	}
	
	public static void popStackInQueue(Queue q, Stack s){
		
		if(s.size()==0){
			return;
		}
		q.add(s.pop());
		popStackInQueue(q, s);
		
	}
	
	public static void takeInput(Queue q){
		
		int num;
		num = s.nextInt();
		while(num!=-1){
			q.add(num);
			num = s.nextInt();
		}
	}
	
}
