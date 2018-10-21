package dummy;

import java.util.Scanner;

public class ReverseArray {
	
	public static void solve(int arr[], int start, int end) {
		if(start >= end) {
			return;
		}
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		solve(arr, start+1, end-1);
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		solve(arr, 0, arr.length-1);
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
