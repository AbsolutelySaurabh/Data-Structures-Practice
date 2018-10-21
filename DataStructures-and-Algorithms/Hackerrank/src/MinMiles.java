import java.util.*;
public class MinMiles {
	
	static Long findMinCal(int[] arr) {
		
		//my logic is to sort in decreasing order and hence fin the value
		//I'll sort in ascending order and willl use the reverse value
		Arrays.sort(arr);
		//int min = Integer.MAX_VALUE;
		Long sum=(long) 0;
	    int j=0;
		for(int i=arr.length-1;i>=0;i--) {
			
			sum += (long)(arr[j] * Math.pow(2, i));
			j++;
		}
		return sum;
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(findMinCal(arr));	
		s.close();
	}	
}
