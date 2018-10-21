package practice;

import java.util.Scanner;

public class SortZeroOne {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		int start = 0, end = n-1;
		while(start < end) {
			if(arr[start] == 0) {
				start++;
			}
			
			if(arr[end] == 1) {
				end--;
			}
			
			if(arr[start] == 1 && arr[end] == 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				
				start++;
				end--;
			}
		}
		
		//print
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
		
		s.close();
		
	}

}
