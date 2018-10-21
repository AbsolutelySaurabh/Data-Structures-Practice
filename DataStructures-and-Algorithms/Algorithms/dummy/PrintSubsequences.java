package dummy;

import java.util.Scanner;

public class PrintSubsequences{
	
	public static void printSubseq(String input, String output) {
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		printSubseq(input.substring(1), output);
		printSubseq(input.substring(1), output + input.charAt(0));
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		printSubseq(str, "");
		s.close();
	}
	
}