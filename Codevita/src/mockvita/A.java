//comment out package line for codevits submission
//package mockvita;

import java.util.Scanner;

public class A {
	
	public static int calc_inv(int sum[], int n){
		
		int inv = 0;
		for(int j = 1; j<n;j ++){
			for(int i=0;i <j; i++){
				if(i<j && sum[i] > sum[j]){
					inv++;
				}
			}
		}
		return inv;
	}
	
	public static void calc_sum(int base_6[], int sum[], int n){
		
		int index = 0;
		for(int i=0;i<n;i++){
			int total = 0;
			while(base_6[i] > 0){
				total = total + base_6[i]%10;
				base_6[i]/=10;
			}
			sum[index] = total;
			index++;
		}
	}
	
	public static int solve(int input[], int n){
		
		int base_6[] = new int[n];
		int index = 0;
		for(int i=0;i <n; i++){
			
			int p_index = 0, num = 0;
			
			while(input[i] > 0){
				int rem  = input[i]%6;
				num = num + (int)Math.pow(10, p_index)*rem;
				input[i]/=6;
				p_index++;
			}
			base_6[index] = num;
			index++;
		}
		
		int sum[] = new int[n];
		calc_sum(base_6, sum, n);
		//now, find all the sub arrays
		int inversions = calc_inv(sum, n);
		return inversions;
	}

	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		
		String line1 = s.nextLine();
        String[] lineVector1;

        //separate all values by comma
        lineVector1 = line1.split(",");
        
		int input[] = new int[n];
		for(int i=0;i <lineVector1.length; i++){
			input[i] = Integer.parseInt(lineVector1[i]);
		}
		System.out.print(solve(input, n));
		//s.close();
	}

}
