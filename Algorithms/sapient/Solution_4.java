package sapient;

import java.util.Scanner;

public class Solution_4 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sonu = s.nextInt();
		int monu = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
		
			arr[i] = s.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			if(arr[i] < sonu) {
				System.out.println("Sonu");
			}else
				if(arr[i] <= (sonu + monu)) {
					System.out.println("Both");
				}
		}
	}
}
