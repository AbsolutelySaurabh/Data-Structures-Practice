package thirty_days_of_code;
import java.util.*;

public class HourGlassSum {
    
	private static int largest(int[][] arr) {
		
//		also include the case
//			 
//			0	0	0
//				0	
//			0	0	0
		
		int max = Integer.MIN_VALUE, sum = 0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				
				if((j+2) < 6 && (i+2)<6) {
							
						sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
						if(sum > max) {
							max = sum;
							//System.out.println("sum: " + sum + " max: " + max);
						}
				}
			}
		}
		return max;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(largest(arr));
        in.close();
    }
}