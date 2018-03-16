package dynamicProgramming;

import java.util.Scanner;
public class LongestSubsequence {

	//LCS
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
			
		System.out.println("lcs length recursively : " + lcs(str1, str2, str1.length(), str2.length()));
		System.out.println("lcs length DP : " + lcs(str1, str2));
		
		//not let's try an algo to print the lcs:
		String diff = lcs_print(str1, str2);
		System.out.println("The lcs is : " + diff);
			
		s.close();
	}

	private static String lcs_print(String str1, String str2) {
		
		//we'll do this using the DP approach only
		//we'll first build up the lcs_memo[][] table, then use it to construct the string
		
		//building the memo table
		int m = str1.length(), n = str2.length();
		int[][] lcs_memo = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				
				if(i==0 || j==0) {
					lcs_memo[i][j] = 0;
				}else {
					
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						lcs_memo[i][j] = 1 + lcs_memo[i-1][j-1];
					}else{
						lcs_memo[i][j] = Math.max(lcs_memo[i-1][j], lcs_memo[i][j-1]);
					}
				}
			}
		}
		
		//we'll start with the end
		String lcs = "";
		
		int i =m, j=n;
		
		while(i>0 && j>0) {
			
			if(str1.charAt(i-1)== str2.charAt(j-1)) {
				
				lcs+=str1.charAt(i-1);
				i--;
				j--;
								
			}else {
				
				if(lcs_memo[i-1][j] > lcs_memo[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		
		return reverse(lcs, "", lcs.length()-1);
	}
	
	private static String reverse(String lcs, String new_lcs, int end_index) {
		if(end_index<0) {
			return new_lcs;
		}
		return reverse(lcs, new_lcs + lcs.charAt(end_index), --end_index);
	}

	//using DP
	private static int lcs(String str1, String str2) {
		
		//Time complexity here: O(n*m)
		//Space complexity: O(m*n);
		
		int m=str1.length(), n=str2.length();
		int[][] lcs_memo = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			
			for(int j=0;j<=n;j++) {
					
					if(i==0 || j==0) {
						lcs_memo[i][j] = 0;
					}else {
						
						if(str1.charAt(i-1) == str2.charAt(j-1)) {
							
							lcs_memo[i][j] = 1 + lcs_memo[i-1][j-1];
						}else {
							
							//if they are no equal
							lcs_memo[i][j] = Math.max(lcs_memo[i][j-1], lcs_memo[i-1][j]);
						}
					}
			}
		}
		return lcs_memo[m][n];
	}

	private static int lcs(String str1, String str2, int m, int n) {
		
		//Time complexity here: O(exponential);
		//Space complexity: O(1)
		
		if( m == 0 || n == 0) {
			return 0;
		}
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1 + lcs(str1, str2, m-1, n-1);
		}
		return Integer.max(lcs(str1, str2, m-1, n) , lcs(str1, str2, m, n-1));
	}
		
}
