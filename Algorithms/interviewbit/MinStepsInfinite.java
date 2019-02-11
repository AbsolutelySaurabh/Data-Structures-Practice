package interviewbit;

import java.util.Scanner;

public class MinStepsInfinite {
	
	public static int min(int a, int b){
		if(a>b){
			return b;
		}
		return a;
	}
	
	public static int minSteps(int a[], int b[]){
		
		//find length of memo
		int max = Integer.MIN_VALUE;
		for(int i=0;i <a.length; i++){
			if(a[i]  >max){
				max = a[i];
			}
		}
		for(int j = 0;j <b.length; j++){
			if(b[j] > max){
				max = b[j];
			}
		}
		int memo[][] = new int[max+3][max+3];
		for(int i=0;i <memo.length; i++){
			for(int j=0; j<memo[0].length ;j++){
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
		memo[a[0]+1][b[0]+1] = 0;
		int index = 1;
		while(index < a.length){
			
			memo[a[index]+1][b[index]+1] = 1 + min(min(min(memo[a[index] + 1-1][b[index]+1-1] , memo[a[index]+1-1][b[index]+1]) , min(memo[a[index]+1][b[index]+1-1], memo[a[index]+1+1][b[index]+1-1])),
					min(min(memo[a[index]+1+1][b[index]+1] , memo[a[index]+1+1][b[index]+1+1]) , min(memo[a[index]+1][b[index]+1+1], memo[a[index]+1-1][b[index]+1+1])));  
			
			index++;
		}
	
		return memo[a[a.length-1]+1][b[b.length-1]+1];
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int A[] = new int[n];
		int B[]  =new int[n];
		
		for(int i=0;i <n;i++){
			A[i] =s.nextInt();
		}
		
		for(int j = 0;j<n ;j++){
			B[j]  =s.nextInt();
		}
		
		System.out.println(minSteps(A, B));
		s.close();
	}

}
