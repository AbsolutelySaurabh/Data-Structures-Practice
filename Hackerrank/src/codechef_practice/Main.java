package codechef_practice;

import java.util.Scanner;

public class Main {
	
	private static int[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
	
	public static int calc_value(int n) {
		
		int min_diff = Integer.MAX_VALUE, index = -1;
		for(int i = 0; i<arr.length ;i++) {
			int diff = n-arr[i];
			if(diff >= 0 && diff < min_diff) {
				min_diff = diff;
				index = i;
			}
		}
		
		return arr[index];
	}
	
	public static int calc_min(int n) {
		
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		int nearest_value = calc_value(n);		
		return  1 + calc_min(n-nearest_value);
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t>0) {
			
			int n = s.nextInt();
			
			System.out.println(calc_min(n));
			
			t--;
		}
	}

}
