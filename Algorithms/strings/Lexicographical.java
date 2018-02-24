package strings;

import java.util.Scanner;

public class Lexicographical {

	public static void main(String[] args) {
		
		String s1, s2;
		Scanner s = new Scanner(System.in);
		s1 = s.next();
		s2 = s.next();
		
		if(s1.compareTo(s2) > 0) {
			System.out.println("s1 > s2");
		}
	}

}
