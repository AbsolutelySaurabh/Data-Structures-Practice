package Stacks;
import java.util.Stack;
import java.util.*;

public class Collection {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack();
		int input1 = s.nextInt();
		int input2 = s.nextInt();

		stack.push(input1);
		stack.push(input2);
		
		//pop() returns the tail element of the stack
		System.out.println(stack.pop());
		
		//returns 1 if found otherwise returns -1
		System.out.println(stack.search(2));
		
	}

}
