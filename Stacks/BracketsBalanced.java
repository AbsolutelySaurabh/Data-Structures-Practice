package Stacks;
import java.util.*;

public class BracketsBalanced {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		String input = new String();
		input = s.next();
		
		Stack<String> stack = fillStack(input);
		if(stack.size() == 0){
			
			System.out.println("true");
			
		}else{
			System.out.println("false");
		}	
	}
	
	public static Stack<String> fillStack(String inp){
		
		//using java collections
		Stack<String> s = new Stack();
		
		for(int i=0;i<inp.length();i++){
			
			if(inp.charAt(i) == '{' || inp.charAt(i) == '[' || inp.charAt(i)=='('){
				
				s.push(String.valueOf(inp.charAt(i)));
			}
			
			if(inp.charAt(i) == '}' || inp.charAt(i) == ']' || inp.charAt(i) == ')'){
				
				if(inp.charAt(i) == '}' && s.peek().equals(String.valueOf('{'))){
					
					s.pop();
										
				}else
				
					if(inp.charAt(i) == ']' && s.peek().equals(String.valueOf('['))){
						
						s.pop();
						
					}else
						
						if(inp.charAt(i) == ')' && s.peek().equals(String.valueOf('('))){
							
							s.pop();
							
						}	
			}
		}
		
		return s;
	}

}
