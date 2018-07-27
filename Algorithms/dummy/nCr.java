package dummy;

import java.util.Scanner;

public class nCr{
	
	public static void print(int memo[][], int n, int r) {
		//przint
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<r+1;j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int calc(int n, int r) {
		
		if(n<r) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		//define the memo
		int memo[][] = new int[n+1][r+1];
		for(int i=0;i<n;i++) {
			memo[i][0] = 1;
		}
		
		for(int j=0;j<r;j++) {
			memo[0][j] = 0;
		}
				
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=r;j++) {
				if(i == j) {
					memo[i][j] = 1;
				}else
					if(j>i) {
						memo[i][j] = 0;
					}else
					{
						memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
					}
			}
		}
		print(memo, n, r);
		return memo[n][r];
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int r = s.nextInt();
		
		System.out.println(calc(n, r));
		s.close();
		
	}
}
