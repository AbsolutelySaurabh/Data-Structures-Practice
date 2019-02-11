package dynamicProgramming;

import java.util.Scanner;

public class RepestedSubsequence {

	public static void main(String[] args) {
		
		//It is same as the LCS, but only thing here is we need to check that 
		// where str[i] == str2[j], then i!=j
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		System.out.println("Length DP ans: " + func(str));
		System.out.println("Print repeated subsequence ans: " + func(str, str.length()));

		s.close();
	}

	private static String func(String str, int m) {
		
		int[][] memo = new int[m+1][m+1];
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=m;j++) {
				
				if(i==0 || j==0) {
					memo[i][j] = 0;
				}
				if(str.charAt(i-1) == str.charAt(j-1)  && i!=j) {
					memo[i][j] = 1 + memo[i-1][j-1];
				}else {
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				}
			}
		}
		
		//now, I have the memo table
		String rcs = "";
		
		int i=1, j=1;
		while(i<=m && j<=m) {
			
			if(memo[i+1][j+1] == (memo[i][j] + 1)) {
				rcs+=str.charAt(i-1);
				i++;
				j++;
			}else {
				
				if(memo[i+1][j] > memo[i][j+1]) {
					
					i++;
				}else {
					j++;
				}
			}
		}
		
		return rcs;
		
	}

	private static int func(String str) {
		
		int[][] memo = new int[str.length()+1][str.length()+1];
		
		for(int i=1;i<=str.length();i++) {
			
			for(int j=1;j<=str.length();j++) {
				
				if(i==0 || j==0) {
					memo[i][j] = 0;
				}
				if(str.charAt(i-1) == str.charAt(j-1)  && i!=j) {
					memo[i][j] = 1 + memo[i-1][j-1];
				}else {
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				}
			}
		}
		return memo[str.length()][str.length()];
	}

}
