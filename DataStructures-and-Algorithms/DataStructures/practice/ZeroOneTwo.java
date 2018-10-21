package practice;
import java.util.*;
public class ZeroOneTwo {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		int prev_z = 0, next_z = 1;
		int prev_2 = n-1, next_2 = n-2;
		
		while(next_z < n && next_2 >= 0) {
			if(arr[next_z] == 0 && arr[prev_z] != 0) {
				int temp = arr[next_z];
				arr[next_z] = arr[prev_z];
				arr[prev_z] = temp;
				
				next_z++;
				prev_z++;
								
			}else
				if(arr[prev_z] == 0) {
					prev_z++;
				}
			
			
			if(arr[next_2] == 2 && arr[prev_2]!=2) {
				int temp = arr[next_2];
				arr[next_2] = arr[prev_2];
				arr[prev_2] = temp;
				
				next_2--;
				prev_2--;
				
			}else
				if(arr[prev_2] == 2) {
					prev_2--;
				}
			
			if(arr[next_z] != 0) {
				next_z++;
			}
			
			if(arr[next_2]!=0) {
				next_2--;
			}
			
		}
		
		//printing
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
		
	}

}
