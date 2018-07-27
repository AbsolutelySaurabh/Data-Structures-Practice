package dummy;

import java.util.Scanner;

public class PrintPermutations {
	
	public static void printPermu(String input, String output) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		for(int i = 0;i<input.length(); i++) {
			printPermu(input.substring(0, i) + input.substring(i+1), output + input.charAt(i));
		}	
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		printPermu(str, "");
		s.close();
	}

}
