package Arrays;
import java.util.*;
public class Swap {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int[] arr = new int[4];
		for(int i=0;i<4;i++) {
			arr[i] = s.nextInt();
		}
		swap(arr, 1, 2);
		
		for(int i=0;i<4;i++) {
			System.out.print(arr[i] + " ");
		}
		
		s.close();
		
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		//return arr;
	}
}
