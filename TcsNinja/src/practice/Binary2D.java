package practice;

import java.util.Scanner;

public class Binary2D {
	
	public static String solve(int n) {
		
		String bin = "";
		while(n > 0) {
			
			int rem = n%2;
			bin+=String.valueOf(rem);
			n/=2;
		}
		
		//then reverse it
		String ans = "";
		for(int i = bin.length()-1; i>=0; i--) {
			ans+=bin.charAt(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		System.out.println(solve(n));
	}

}
