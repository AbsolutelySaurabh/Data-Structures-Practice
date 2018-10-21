package sapient;

import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	
	private static int findSum(int[] arr, int index) {
		int sum=0;
		for(int i=0;i<=index-1; i++) {
			sum+=arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextLong();
		}
		Arrays.sort(arr);
		int not_dis=0;
		
		//need to use DP, otherwise will get O(n2);
		long sumTillNow = 0;
		//now count the number of elements at i where sum from 0->i-1 is <= arr[i]
		for(int i=0; i<n ;i++){
			
			if(arr[i] >= sumTillNow) {
				not_dis++;
				sumTillNow += arr[i];
			}else {
				
				sumTillNow+=arr[i];
			}
		}
		
		System.out.println(not_dis);
		
	}

}
