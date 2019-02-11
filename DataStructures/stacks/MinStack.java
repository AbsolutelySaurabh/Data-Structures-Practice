package stacks;
import java.util.*;
public class MinStack {
	
	//This class is to perform push(), pop(), getMin() in O(1)
	//I'll also use an auxillary stack to track the minimum
	
	public static Stack<Integer> stack_1 = new Stack();
	public static Stack<Integer> stack_2 = new Stack();//this is the auxillary stack
	
	public static Scanner s;
	public static void main(String[] atgs){
		
		s = new Scanner(System.in);
	
		pushOperation();		
		popOperation();
		getMin();
		
	}
	
	public static void getMin(){
		
		System.out.println("This will be given by the top of the stack_2(auxillary stack)");
		System.out.println("The minimum is: " + stack_2.peek());
		
	}
	
	public static void popOperation(){
		
		System.out.println("Enter 99 to delete the element in the stack");
		int response = s.nextInt();
		if(response == 99){
			
			if(stack_1.pop() == stack_2.peek()){
				stack_2.pop();
			}
			
		}
	}
	
	public static void pushOperation(){
		
		//Add the Integer.INT_MAX to the stack_2(auxillary)
		stack_2.push(Integer.MAX_VALUE);
		
		System.out.println("Enter the first element in the stack: ");
		int num = s.nextInt();
		while(num!=-1){
			
			stack_1.push(num);
			if(num < stack_2.peek()){
				
				stack_2.push(num);
			}
			num = s.nextInt();
		}
	}
	
}
