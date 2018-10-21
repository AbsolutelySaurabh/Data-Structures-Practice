package codevita16;

import java.util.Scanner;

public class MInProductArray {
	
	public static void decrement(int a[], int index, int degree) {
		
		for(int i=0; i<degree; i++) {
			a[index]-=2;
		}
	}
	public static void increment(int a[], int index, int degree) {
		
		for(int i=0; i<degree; i++) {
			a[index]+=2;
		}
	}
	
	public static int product(int a[], int b[]) {
		
		int prod = 0;
		for(int i=0; i<a.length; i++) {
			prod+=a[i]*b[i];
		}
		return prod;
	}
	
	public static int solve(int a[], int b[], int k) {
		
		//do operations in the minimum element of a
		//find minimum in a[]
		int min = Integer.MAX_VALUE, minIndex = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}
		
		//check the minimum condition
		if(b[minIndex] * a[minIndex] > 0) {
			
			//either both positive
			if(a[minIndex] > 0 && b[minIndex] > 0) {
				
				//decrement the a[minIndex]
				decrement(a, minIndex, k);
			}else
				//either both positive
				if(a[minIndex] < 0 && b[minIndex] < 0) {
					
					//increment the a[minIndex]
					increment(a, minIndex, k);
				}
			
			
		}else
			if(a[minIndex]*b[minIndex] < 0) {
				//anyone negative
				//if a[minIndex] < 0
				if(a[minIndex] < 0) {
					//decrement a[minIndex]
					decrement(a, minIndex, k);
					
				}else
					if(b[minIndex] < 0) {
						//increment a[minIndex]
						increment(a, minIndex, k);
					}
					
			}
		
		return product(a, b);
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String nk = s.nextLine();
		String arr_nk[] = nk.split(" ");
		int n = Integer.parseInt(arr_nk[0]);
		int k = Integer.parseInt(arr_nk[1]);
		
		//input array
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i=0;i <n;i ++) {
			a[i] = s.nextInt();
		}
		for(int i=0;i <n; i++) {
			b[i] = s.nextInt();
		}
		
		System.out.println(solve(a, b, k));
		s.close();
	}

}
