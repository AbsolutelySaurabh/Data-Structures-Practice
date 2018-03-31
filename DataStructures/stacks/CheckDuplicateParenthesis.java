package stacks;
import java.util.*;
public class CheckDuplicateParenthesis {
	
	//My logic is that:
	//Push everything to the stack one by one till you get the closing bracket, 
	//The moment we get the closing bracket, pop everthing from the stack till we get the opening brackt.
	//If we get the immediate opening bracket in the stack after getting hte closing bracket then it's DUPLICATE.
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		if(checkDuplicate(str)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
	}

	public static boolean checkDuplicate(String str){
		
		Stack stack = new Stack();
			
		for(int i=0;i<str.length();i++){
			
			if(str.charAt(i)!=')'){
				stack.push(str.charAt(i));
//				System.out.println("above " + i);

			}else{
				
				System.out.println(stack.size());
				char p = (char)stack.peek();

				if(p == '('){
					//check that if the first immediate values in the stack is the opening bracket
					return true;
				}else{
				
					p = (char)stack.peek();
					while(p!='('){
						//pop till you get the opening bracket
						stack.pop();
						p = (char)stack.peek();
					}
					stack.pop();
				}
				
			}
				
		}
		
		return false;
	}
}
