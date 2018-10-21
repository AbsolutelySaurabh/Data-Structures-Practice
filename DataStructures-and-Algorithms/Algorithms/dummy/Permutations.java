package dummy;

import java.util.Scanner;

public class Permutations {
	
	public static String swap(String str, int a, int b) {
		
		if(a == b) {
			return str;
		}
		
		char[] arr = str.toCharArray();
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		return String.valueOf(arr);
	}
	
	public static void solve(String str, int l, int r) {
		
		if(l == r) {
			System.out.println(str);
		}
		for(int i = l; i<=r; i++) {
			
			str = swap(str, l, i);
			solve(str, l+1, r);
			str = swap(str, l, i);
		}
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		solve(str, 0, str.length()-1);
		
		
	}

}
