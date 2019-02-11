package cdv_2016;

import java.util.Scanner;

public class LogicPyramid {
	
	public static void solve(String arr[], int row){
		
		if(arr.length <= 0){
			return;
		}
		
		//then
		int index = 1;
		int row_count = 0;
		int i = 0;
		while(i<arr.length &&row_count < row){
			
			for(int j = 0; j<index && i<arr.length; j++){
				String formatted = String.format("%05d", Integer.parseInt(arr[i]));
				System.out.print(formatted + " ");
				i++;
			}
			System.out.println();
			index+=1;
			row_count++;
		}
			
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		s.nextLine();
		String input = s.nextLine();
		String arr_input[] = input.split(" ");
		
		solve(arr_input, row);
		
	}

}
