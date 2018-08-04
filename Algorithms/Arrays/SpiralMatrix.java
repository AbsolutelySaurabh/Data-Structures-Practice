package Arrays;

import java.util.Scanner;

public class SpiralMatrix {
	
	public static int[] spiralMatricUtil(int arr[][], int m, int n) {
		
		if(m == 1) {
			int output[] = new int[n];
			int index = 0;
			for(int i=0;i<n;i++) {
				output[index] = arr[0][i];
				index++;
			}
			return output;
		}else
			if(n == 1) {
				int output[] = new int[m];
				int index = 0;
				for(int i=0;i<m;i++) {
					output[index] = arr[i][0];
					index++;
				}
				return output;
			}
		
		int up_start = 0, up_end = n-1;
		int down_start = 0, down_end = m-1;
		int output[] = new int[m*n];
		int o_index = 0;
		while(down_start <= down_end) {
			
			
			int i, j;
			//System.out.println("prev_ " + prev_up + " prev_down: " + prev_down + " prev_left: " + up_start + " prev_right: " + prev_right);
			for(i = up_start, j = up_start; j<=up_end ; j++) {
				if(o_index < output.length) {
					output[o_index] = arr[i][j];
					o_index++;	
				}
			}
			
			//this is necessart for m = 3, n = 4 cases
			if(down_start != down_end) {
				for(i = up_start+1, j = up_end; i<=down_end; i++) {
					if(o_index < output.length) {
						output[o_index] = arr[i][j];
						o_index++;	
					}
				}
				
				for(i = down_end, j = up_end-1; j>=up_start; j--) {
					if(o_index < output.length) {
						output[o_index] = arr[i][j];
						o_index++;	
					}
				}
				//end--;
				for(i = down_end-1, j = up_start; i>down_start; i--) {
					if(o_index < output.length) {
						output[o_index] = arr[i][j];
						o_index++;	
					}
				}
			
			}
			up_end--;
			down_end--;
			
			up_start++;
			down_start++;
		}
		return output;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		
		int arr[][] = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		int output[] = spiralMatricUtil(arr, m, n);
		for(int i=0;i<output.length; i++) {
			System.out.print(output[i]+ " ");
		}
		s.close();
	}

}
