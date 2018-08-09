package dummy;

import java.util.Scanner;

public class Subsequences {
	
	public static void solve(String input, String output) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		solve(input.substring(1), output + input.charAt(0));
		solve(input.substring(1), output);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		solve(str, "");
		
	}

}
