package dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//0, 1, 1, 2, 3;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Recursive: " + fibonacci(n));
		
		//now trying the dp approach
		int[] memo = new int[n+1];
		//add the base cases to the memo table
		memo[0] = 0;
		memo[1] = 1;
		System.out.println("DP: " + fibonacci(n, memo));
		s.close();
	}

	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}
		if(n== 1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	private static int fibonacci(int n, int[] memo) {
		
		//use an memoay to store values here with size() n+1;
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		if(memo[n] == 0) {
			int f = fibonacci(n-1,memo) + fibonacci(n-2,memo);
			memo[n] = f;
		}
		return memo[n];
	}

}
