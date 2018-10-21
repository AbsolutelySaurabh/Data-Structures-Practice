package practice;

import java.util.Scanner;

public class LongestIncrSubseq {
	
	public static void solve(int arr[]) {
		
		int start = 0, end = 0, max = Integer.MIN_VALUE, max_start = 0, max_end = 0;
		int p = 0, n = 1;
		for(int i=0; i<arr.length; i++) {
			if(arr[n] > arr[p]) {
				n++;
				end++;
				
			}else {
				int length = end - start;
				if(length > max) {
					max = length;
					max_start = start;
					max_end = end;
				}
				p = i;
				n = i+1;
				start = p;
				end = start;
			}
		}
		
		//max length
		System.out.println("max length: " + max+1);
		//max subarray
		for(int i=max_start; i<=max_end; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		solve(arr);
		s.close();
	}

}
