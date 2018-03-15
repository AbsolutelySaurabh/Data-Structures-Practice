package dynamicProgramming;

import java.util.Scanner;

public class BinomialCoeff {
	
	/**
			C(n, k) = C(n-1, k-1) + C(n-1, k)
	
				where x^k is in (1 + x)^n
				
					eg: C(4, 2) = 6;
	
	**/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		System.out.println("recursive ans: " + binomialCoeff(n, k));
		
		//let's try the dp approach now
		System.out.println("DP ans: " + binomialCoeff(n, k, new int[n+1][k+1]));
		s.close();
		
	}
	
	private static int binomialCoeff(int n, int k, int[][] memo) {
		//base case
		//C(n, n) || C(n, 0)
		if(n == k || k==0) {
			return 1;
		}
		
		if(memo[n][k] == 0) {
			
			int bin = binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);		
			memo[n][k] = bin;
		}
		return memo[n][k];
	}

	private static int binomialCoeff(int n, int k) {
		//base case
		//C(n, n) || C(n, 0)
		if(n == k || k==0) {
			return 1;
		}
		return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);		
	}

}

