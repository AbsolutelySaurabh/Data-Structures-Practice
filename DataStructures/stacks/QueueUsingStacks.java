package stacks;
import java.util.*;

public class QueueUsingStacks {
	
	public static Scanner s;
	public static void main(String[] args){
		
		s = new Scanner(System.in);
		
		solveByDequeueCostly();
	}
	
	public static void solveByDequeueCostly(){
		
//		implement queue using 2 stacks and making Dequeue operation costly
		
//		In this operation for enqueue--> directly push to stack 1;
//		In the dequeue operation--> transfer s1 to stack s2, then pop() s2, then transfer s2 to s1;
//	
//		In above the Dequeue() operation will be costly;
//		Do reverse for making enqueue operation costly.
		
		Stack<Integer> s1 = new Stack();
		
		s1 = enqueue_1(s1);
		s1 = dequeue_1(s1);
	
		printOutput(s1, 0);
	}
	
	public static void printOutput(Stack<Integer> s, int index){
		if(index == s.size()){
			return ;
		}
		
		System.out.println(s.get(index));
		printOutput(s, ++index);
		
		return;
	}
	
	public static Stack<Integer> enqueue_1(Stack<Integer> s1){
		
		int num = s.nextInt();
		while(num!=-1){
			s1.push(num);
			num = s.nextInt();
		}
		
		return s1;
	}
	
	public static Stack<Integer> dequeue_1(Stack<Integer> s1){
		
		Stack<Integer> s2 = new Stack();
		//transport s1 to s2;
		while(s1.size()!=0){
			s2.push(s1.pop());
		}
		
		//then pop from s2;
		int pop_result = s2.pop();

		while(s2.size()!=0){
			s1.push(s2.pop());
		}
		
		return s1;
		
	}
}
