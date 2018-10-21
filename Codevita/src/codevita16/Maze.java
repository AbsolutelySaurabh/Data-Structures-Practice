package codevita16;

import java.util.Scanner;

public class Maze {
	
	public static Boolean isPrime(int i) {
		
		if(i == 2 || i==3 || i== 5) {
			return true;
		}
		
		if(i%2 == 0 || i%3 == 0 || i%5 == 0) {
			return false;
		}
		
		for(int j = 6; j*j<=i ;j++) {
			if(i%j == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int solvePrime(int n) {
		
		
		for(int i = 2; ; i++) {
			
			if(isPrime(i)) {
				
				if(n-1 == 0) {
					return i;
				}else
					n--;
			}
		}
	}
	
	public static int solveFibo(int n) {
		
		int fibo[] = new int[n+1];
		fibo[0] = 1;
		fibo[1] = 1;
		
		if(n-1 == 0) {
			return 1;
		}
		if(n-1 == 1) {
			return 1;
		}
		
		for(int i = 2; i<=n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		return fibo[n-1];
	}
	
	public static int solve(int n) {
		
		if(n%2 == 0) {
			
			return solvePrime(n/2);
		}else
			if(n%2 != 0) {
				
				return solveFibo((n+1)/2);
			}
		return 0;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		int n = Integer.parseInt(str);
		System.out.println(solve(n));
				;
		
	}

}
