package codevita16;

import java.util.Scanner;

public class Practice {
	
	public static Boolean isPrime(int n) {
		
		if(n == 2 || n == 3 || n==5) {
			return true;
		}
		
		if(n%2 == 0 || n%5== 0 || n%3 == 0) {
			return false;
		}
		for(int i = 2; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int findPrime(int n) {
		
		int ans = 0;
		for(int i = 2; i<10000 ;i++) {
			
			if(isPrime(i) && n == 0) {
				return ans;
				
			}else
				if(isPrime(i)) {
					ans = i;
					n--;
				}
		}
		return 0;
	}
	
	public static int findFibo(int n) {
		
		int memo[] = new int[1000];
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
		
		if(n-1 == 1|| n-1 == 2 || n-1==0) {
			return memo[n-1];
		}
		
		for(int i = 3; i<=n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n-1];
	}
	
	public static int solve(int n) {
		
		if(n%2 == 0){
			return findPrime(n/2);
		}else
			if(n%2!=0) {
				return findFibo((n/2) + 1);
			}
		return 0;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solve(n));
		
	}

}
