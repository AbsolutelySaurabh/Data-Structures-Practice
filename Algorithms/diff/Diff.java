package diff;
import java.util.ArrayList;
import java.util.Scanner;
public class Diff {
	
	public static int INDEX_NOT_FOUND = -1;
	public static String EMPTY="";
	private static ArrayList<SingleCharDiff> al_diff;

	//LCS
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		
		//not let's try an algo to print the lcs:
		String diff = lcs_print(str1, str2);
		System.out.println("The diff is : " + diff);
		
		System.out.println("Calculating DIFF..... ");
		
		al_diff = new ArrayList<>();
		checkDiff(str1, str2, diff);
		
		//Now print all the diffs:
		printDiffArrayList(0);

			
		s.close();
	}

	private static void printDiffArrayList(int index) {
		if(index == al_diff.size()) {
			return;
		}
		System.out.print(al_diff.get(index).getValue() + "( " + al_diff.get(index).getBehaviour() + " )" + " , ");
		printDiffArrayList(++index);
	}

	private static void checkDiff(String str1, String str2, String lcs) {
		
		//if it's present in s1, but not in lcs then -
		
		for(int i=0;i<str1.length();i++) {
			if(!search(str1.charAt(i), lcs, 0, str1.length())){
				SingleCharDiff diff_char = new SingleCharDiff(str1.charAt(i));
				diff_char.setBehaviour('-');
				al_diff.add(diff_char);
			}
		}
		
		//if it's present in s2 but not in lcs, then '+'
		for(int i=0;i<str2.length();i++) {
			if(!search(str2.charAt(i), lcs, 0, str2.length())){
				SingleCharDiff diff_char = new SingleCharDiff(str2.charAt(i));
				diff_char.setBehaviour('+');
				al_diff.add(diff_char);
			}
		}
				
	}

	private static Boolean search(char c, String lcs, int startIndex, int endIndex) {
		for(int i=0;i<lcs.length();i++) {
			if(lcs.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}

	private static String lcs_print(String str1, String str2) {
		
		//we'll do this using the DP approach only
		//we'll first build up the lcs_memo[][] table, then use it to construct the string
		
		//building the memo table
		int m = str1.length(), n = str2.length();
		int[][] lcs_memo = lcs(str1, str2);
		
		//the diff lcs
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
	private static int[][] lcs(String str1, String str2) {
		
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
		return lcs_memo;
	}	
}
