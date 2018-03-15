package dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//0, 1, 1, 2, 3;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Recursive: " + fibonacci(n));
		
		//now trying the dp approach
		int[] arr = new int[n+1];
		//add the base cases to the array
		arr[0] = 0;
		arr[1] = 1;
		System.out.println("DP: " + fibonacci(n, arr));
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
	
	private static int fibonacci(int n, int[] arr) {
		
		//use an array to store values here with size() n+1;
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		if(arr[n] == 0) {
			int f = fibonacci(n-1,arr) + fibonacci(n-2,arr);
			arr[n] = f;
		}
		return arr[n];
	}

}
