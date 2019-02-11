package cracking_the_code;

import java.util.Scanner;

public class BBsort {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		int i=0;
		while(n>0) {
			arr[i] = s.nextInt();
			i++;
			n--;
		}
		
		int swap_count = bubbleSort(arr);
		System.out.println("Number of swaps: " + swap_count);
		System.out.println("Index 0: " + arr[0]);
		System.out.println("Last element: " + arr[arr.length-1]);
		
		s.close();
	}

	private static int bubbleSort(int[] arr) {
	
		int swap_count=0;
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j] > arr[j+1]) {
					swap_count++;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return swap_count;
	}

}
