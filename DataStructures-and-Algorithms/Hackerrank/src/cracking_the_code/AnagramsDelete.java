package cracking_the_code;

import java.util.Scanner;

public class AnagramsDelete {
	
	//take arrays of length 26 as the maxn unique character in abcde is 26 no.
	
	public static int countAnagrams(String s1, String s2) {
		
	//maintain two count1, count2 arrays, containign the frequency of each character in string
	int[] count1 = new int[26], count2 = new int[26];
	//frequency of each character in s1
	for(int i=0;i<s1.length();i++) {
		count1[s1.charAt(i) - 'a']++;;
	}
	
	for(int i=0;i<s2.length();i++) {
		count2[s2.charAt(i) - 'a']++;
	}
	
	int result=0;
	
	//not calulate the result
	for(int i=0;i<26;i++) {
		result+=Math.abs((count1[i] - count2[i]));
	}
	return result;
	
	}

	public static void main(String[] args) {
		
		String s1, s2;
		Scanner s = new Scanner(System.in);
		s1 = s.nextLine();
		s2 = s.nextLine();
		
		System.out.println(countAnagrams(s1, s2));
		s.close();

	}

}
