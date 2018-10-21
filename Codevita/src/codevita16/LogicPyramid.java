package codevita16;

import java.util.Scanner;

public class LogicPyramid {

	public static void solve(int n) {
		
		int element = 6;
		int increment = 22;
		for(int row = 0; row<n; row++) {
			int column = row;
			while(column>=0) {
				
				System.out.print(String.format("%05d", element) + " ");
				element+=increment;
				increment+=16;
				column--;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		solve(n);
		s.close();
	}

}
