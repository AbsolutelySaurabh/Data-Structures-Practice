package arrays;

import java.util.Scanner;

public class SortGroup {
	
	public static void print(int arr[]) {
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] reverseGroupsUtil(int arr[], int k, int n) {
		//taking n > k;
		int mid = k/2;
		int start = 0, end = k-1;
		int index = 0;
		int overall_start = 0, overall_end = k-1;
		while(index < n) {
			
			while(overall_end >= n) {
				overall_end--;
			}
			mid = (overall_start + overall_end)/2;
			
			System.out.println("start: " + arr[overall_start] + " end: " + arr[overall_end] + " arr[mid]: " + arr[mid]);
			if(overall_end <= (overall_start+1)) {
				//in case if remaining of size 2
				int temp = arr[overall_start];
				arr[overall_start] = arr[overall_end];
				arr[overall_end] = temp;
			}else {
				start = overall_start;
				end = overall_end;
				while(start<end) {
					//swap end, start
					int temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
					start++;
					end--;
				}
			}
			
			overall_start+=k;
			overall_end+=k;
			index+=k;
		}
		return arr;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			
			int n = s.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
			}
			int k = s.nextInt();
			
			print(reverseGroupsUtil(arr, k, n));
			t--;
		}
		s.close();
	}

}