package practice;

import java.util.Scanner;

public class SumArr {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		
		for(int i=0; i<n1; i++) {
			arr1[i] = s.nextInt();
		}
		for(int j=0; j<n2; j++) {
			arr2[j] = s.nextInt();
		}
		
		int ans[] = find_sum(arr1, arr2);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		
		s.close();
	}

	private static int[] find_sum(int[] arr1, int[] arr2) {
		
		//supposing arr1.length >= arr2.length
		int end1 = arr1.length-1, end2 = arr2.length-1;
		int carry = 0, sum = 0;
		int new_arr[] = new int[end1+1];
		int new_end = end1;
		while(end1 >= 0) {
			
			if(end1>=0 && end2>=0) {
				sum = arr1[end1] + arr2[end2];
			}else {
				sum = arr1[end1];
			}
			sum += carry;
			new_arr[new_end] = sum%10;
			
			carry = sum/10;
			
			new_end--;
			end1--;
			end2--;
		}
		return new_arr;
	}

}
