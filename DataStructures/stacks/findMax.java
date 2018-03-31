package stacks;
import java.util.*;

public class findMax {
	
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args){
				
		Stack<Integer> stack = new Stack();
		int max = enqueue(stack);
		
		System.out.println(max);
		
		//Now findMaxInGivenStack
		int max_in_stack = findMaxInGivenStack(stack, 0, Integer.MIN_VALUE);
		System.out.println(max_in_stack);

	}
	
	public static int enqueue(Stack<Integer> stack){
		
		int num = s.nextInt();
		int max = Integer.MIN_VALUE;
		while(num!=-1){
			if(num>max){
				max = num;
			}
			stack.push(num);
			num = s.nextInt();
		}
		
		return max;
		
	}
	
	public static int findMaxInGivenStack(Stack<Integer> stack, int index, int max){
		if(index == stack.size()){
			return max;
		}
		
		if(stack.get(index)>= max){
			max = stack.get(index);
		}
		
		return findMaxInGivenStack(stack, ++index, max);
	}
}
