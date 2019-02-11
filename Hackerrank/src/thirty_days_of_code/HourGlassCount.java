package thirty_days_of_code;

import java.util.Scanner;

public class HourGlassCount {
	
	private static int count_hour_glass(int[][] arr, int count) {
				
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				
				if((j+2) < 6 || (i+2)<6) {
					
					if(arr[i][j] == 1 || arr[i][j+1] == 1 || arr[i][j+2]==1) {
						
						if(arr[i+1][j+1] == 1) {
							
							if(arr[i+2][j]==1 && arr[i+2][j+1]==1 && arr[i+2][j+2]==1) {
								count++;
							}
						}
					}
				}
				//i++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int[][] arr = new int[6][6];
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println(count_hour_glass(arr, 0));
		s.close();
	}

}
