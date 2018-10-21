package practice;

import java.util.*;

public class PushZeroEnd {
	
	public static int searchFirstZero(int arr[], int start) {		
		for(int i=start;i <arr.length;i++) {
			if(arr[i] == 0) {
				return i;
			}
		}
		return 0;
	}
	
	public static int searchFirstNonZero(int arr[], int start) {
		for(int i = start; i<arr.length; i++) {
			if(arr[i]!=0) {
				return i;
			}
		}
		return arr.length;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		//push 0 to end
		//searchForFirst Zero
		int startZero = 0;
		int firstZero = searchFirstZero(arr, startZero);
		int firstNonZero = searchFirstNonZero(arr, firstZero);
		while(firstNonZero!=arr.length) {
			
			//swap
			int temp = arr[firstZero];
			arr[firstZero] = arr[firstNonZero];
			arr[firstNonZero] = temp;
			
			startZero = firstZero+1;
			firstZero = searchFirstZero(arr, startZero);
			firstNonZero = searchFirstNonZero(arr, firstZero);
		}
		
		//print
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		s.close();
	}

}
