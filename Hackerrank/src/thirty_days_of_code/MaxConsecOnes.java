package thirty_days_of_code;

import java.util.Scanner;

public class MaxConsecOnes {
	
	private static int convertToBinaryAndCountConsecutives(int decimal) {
		
		int temp[] = new int[1000];
		int i=0;
		while(decimal>0) {
			int rem = decimal%2;
			temp[i] = rem;
			i++;
			decimal/=2;
		}
		//now we an array with binary conversion, in reverse order
		//now we need to find the max. consecutive 1's
		
		//Algo 1: find all subarrays with 1, and return the largest array.
		
		//Algo 2: take a max value and count++ if there is 1 and reset when =0, and compare count with max;
		int max = Integer.MIN_VALUE, count = 0;
		for(int j=i; j>=0;j--) {
			if(temp[j] == 1) {
				count++;
			}else {
				count=0;
			}
			if(count > max) {
				max = count;
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int decimal = s.nextInt();
		System.out.println(convertToBinaryAndCountConsecutives(decimal));
	}

}
