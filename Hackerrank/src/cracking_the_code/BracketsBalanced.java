package cracking_the_code;

/**
 * @author "AbsolutelySaurabh"
 */
import java.util.*;
public class BracketsBalanced {
	
	public static Boolean checkBalance(Stack<Character> stack, String brackets) {
		
		int i=0;
		while(i!=brackets.length()) {
			if(brackets.charAt(i) == '(' || brackets.charAt(i) == '[' || brackets.charAt(i) == '{') {
				stack.push(brackets.charAt(i));
			}else
				if(!stack.isEmpty()) {
					if(brackets.charAt(i) == ')') {
						if(stack.pop()!='(') {
							return false;
						}
					}else
						if(brackets.charAt(i) == ']') {
							if(stack.pop()!='[') {
								return false;
							}
						}else
							if(brackets.charAt(i) == '}') {
								if(stack.pop()!='{') {
									return false;
								}
							}
				}else {
					return false;
				}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		//if not written the below line, it'll read blank in nextLine() command, which we're using below to accept string from buffer
		//writing s.nextLine() will consume the things in the buffer.
		s.nextLine();
		while(t>0) {
			String brackets = s.nextLine();
			Stack<Character> stack = new Stack<Character>();
			
			if(checkBalance(stack, brackets)) {
				System.out.println("YES");
			}else {
				System.out.print("NO");
			}
			t--;
		}
		s.close();
		
	}

}
