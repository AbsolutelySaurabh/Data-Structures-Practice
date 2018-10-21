package dummy;

import java.util.Scanner;

public class ReverseNumber {
	
	public static int solve(int n) {
		
		int num = 0;
		while(n > 0) {
			
			int rem = n%10;
			num = num*10 + rem;
			n/=10;
		}
		return num;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solve(n));
	}

}
