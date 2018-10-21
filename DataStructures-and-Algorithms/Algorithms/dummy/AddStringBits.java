package dummy;

import java.util.Scanner;

public class AddStringBits {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		
		int a = Integer.parseInt(str1);
		int b = Integer.parseInt(str2);
	
		int c = a+b;
		
		System.out.println("sum: " + Integer.valueOf(c).byteValue());
		
	}
}