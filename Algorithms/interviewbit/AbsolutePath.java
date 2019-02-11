package interviewbit;

import java.util.Scanner;
import java.util.Stack;

public class AbsolutePath {
	
	public static String solve(String input){
		
		//remove all .
		input = input.replaceAll("[.]", "");
		System.out.println(input);
		String output = "";
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i <input.length(); i++){
			stack.push(input.charAt(i));
		}
		
		//clean the ends
		if(!stack.isEmpty()){
			while(!stack.isEmpty() && stack.peek() == '/'){
				stack.pop();
			}
		}
		StringBuilder str = new StringBuilder(output);
		if(!stack.isEmpty()){
			while(stack.peek()!='/'){
				if(stack.peek()!='.'){
					str.append(stack.pop());
				}else if(stack.peek() == '.'){
					stack.pop();
				}
			}
		}
		str.reverse();
		if(!stack.isEmpty()){
			if(stack.peek()!='.'){
				str.insert(0, "/");
			}else if(stack.peek() == '.'){
				stack.pop();
			}		
		}
		//remove the adjacent
		if(!stack.isEmpty()){
			stack.pop();
		}
		
		//now, check for case /home//abc;
		// /home/
		if(!stack.isEmpty()){
			if(!stack.isEmpty() && stack.peek() == '/'){
				while(!stack.isEmpty() && stack.peek() == '/'){
					stack.pop();
					while(!stack.isEmpty() && stack.peek() !='/'){
						if(stack.peek()!='.'){
							str.insert(0, stack.pop());
						}else if(stack.peek() == '.'){
							stack.pop();
						}
					}
					if(!stack.isEmpty()){
						stack.pop();
					}
				}
			}
		}
		
//		if(str.charAt(0)!='/'){
//			str.insert(0, '/');
//		}
		
		return str.toString();
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(solve(str));
		
	}

}
