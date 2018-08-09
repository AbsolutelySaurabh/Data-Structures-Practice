package dummy;

import java.util.Scanner;

public class Pallindrome {
	
	public static Boolean check(String str, int start, int end) {
		if(start >= end) {
			return true;
		}
		if(str.charAt(start)!=str.charAt(end)) {
			return false;
		}
		return check(str, start+1, end-1);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		if(check(str, 0, str.length()-1)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		
	}

}
