package dynamicProgramming;

import java.util.*;

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
		// ? Why we used a 2D table here:
		// ans: cz the question needs relation b/w n, k to memorize
		// 	which can only be possible with the 2D table.
		
		System.out.println("Recursive DP ans: " + binomialCoeff(n, k, new int[n+1][k+1]));
		
		//let's try the iterative dp approach
		System.out.println("Iterative DP ans: " + iterative(n, k, new int[n+1][k+1]));
		
		s.close();
		
	}
	
	private static int iterative(int n, int k, int[][] is) {
		
		//Time complexity, auxiliary space: O(n*k)
		
		int[][] memo = new int[n+1][k+1];
		for(int i=0; i<=n; i++) {
			for(int j=0;j<= Math.min(i, k);j++) {
				
				//taking j = min(i, k)
				// cz we can't afford: C(0, 1), if k = 1;
				// i.e. for i=1, k = 2, we just wanna go for C(1, 0), C(1, 1) avoiding C(1, 2)
				
				if(j == 0 || j == i) {
					memo[i][j] = 1;
				}else {
					memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
				}
			}
		}
		return memo[n][k];	
	}

	private static int binomialCoeff(int n, int k, int[][] memo) {
		//base case
		//C(n, n) || C(n, 0)
		
		//Time complexity: O(2^(the number of iterations) = 2^k or MAX 2^n
		//Auxiliary space: O(n*k);
		
		if(n == k || k==0) {
			memo[n][k] = 1;
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
		
		//Time complexity: O(2^( number of iterations)
		
		if(n == k || k==0) {
			return 1;
		}
		return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);		
	}

}

