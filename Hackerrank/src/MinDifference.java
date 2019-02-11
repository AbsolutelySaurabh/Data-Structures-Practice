import java.util.*;
/* Java program to find a Pair which has maximum score*/

public class MinDifference {
	
	//this is a normal method to do it but has a complexity of (N^2).
	
	public static int minDiff(int[] arr, int index) {
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(min>(Math.abs(arr[i] - arr[j]))) {
					min = Math.abs(arr[i] - arr[j]);
				}
			}
		}
		return min;
	}
	
	public static int sort(int[] arr) {
		
		int min = arr[arr.length-1] - arr[0];
		for(int i=0;i<arr.length-1;i++) {
			int temp_min = arr[i+1] - arr[i];
			if(temp_min < min) {
				min = temp_min;
			}
		}
		return min;
	}
	
	//The other approach is to first sort the list( of absolute values integers) 
	//and take the difference of the first two.
	//Like list of (3, -7, 0) will become (3, 7, 0) in absolute and (0, 3, 7) when sorted
	//we'll use Merge sort for sorting as it's complexity is O(n * log(n));
	
	public static int minDiff(int arr[]) {
		//int min;
		Arrays.sort(arr);
		//minDiff(arr, 0);
		
		return sort(arr);
		
//        The below case will be wrong in case of duplicate entries ex (0, 1, 6, 6);
//		min = abs_arr[1] - abs_arr[0];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		   // Pair to store the maximum marks of a student with its name\
		
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		//System.out.println(minDiff(arr, 0));
		System.out.println(minDiff(arr));
		s.close();
	}
	
	
}
