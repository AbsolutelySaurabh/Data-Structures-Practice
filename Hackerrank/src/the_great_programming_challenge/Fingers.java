package the_great_programming_challenge;

import java.util.Scanner;

public class Fingers {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(count(n));
		
	}

	private static int count(int n) {
		
		int right_to_left = 1;
		int left_to_right = 5;
		int right_side = 0, left_side = 0;
		
		for(int i=1; i<=n; i++) {
			
			if(right_to_left == 5 || left_to_right == 1) {
				right_to_left = 1;
				left_to_right = 5;
				
				left_side = 1;
			}else {
				right_side = 1;
			}
			
			right_to_left ++;
			left_to_right--;
		}
		if(right_side == 1) {
			return right_to_left-1;
		}
		return left_to_right+1;
	}

}
