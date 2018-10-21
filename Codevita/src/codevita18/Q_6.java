package codevita18;

import java.util.Scanner;

public class Q_6 {
	
	public static int findMax(int arr[], int start, int end) {
		
		int max = -1, maxIndex = -1;
		for(int i=start; i<end; i++) {
			
			if(arr[i]  >max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static int findMin(int arr[], int start, int end) {
		
		int min = 9999, minIndex = -1;
		for(int i=start; i<end; i++) {
			
			if(arr[i]  < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void swap(int arr[], int a, int b) {
		
		int temp  =arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
	
	public static void solve(int n, int index, int arr[]) {
		
		
		int maxIndex = findMax(arr, 0, arr.length-1);
		int max = arr[maxIndex];
		
		int minIndex = findMin(arr, 0, arr.length-1);
		int min = arr[minIndex];
		
		int prod = 0;
		int visited[] = new int[arr.length];
		for(int i = 0;i <visited.length; i++) {
			visited[i] = 0;
		}
		
		if(maxIndex!=index) {
			
			swap(arr, index, minIndex);
			prod+=arr[index]*arr[minIndex];
			minIndex = index;
			
			//chekc unstability now
			//now minIndex = index
			//swap maxINdex with index
			swap(arr, minIndex, maxIndex);
			prod+=arr[maxIndex]*arr[minIndex];
			visited[index] = 1;
			//now the max is at right place
			//now check for other
			
			minIndex = maxIndex;
			//find max i remaining
			max = -1;
			for(int i = 0;i <arr.length; i++) {
				if(i!=index) {
					if(arr[i] > max) {
						max = arr[i];
						maxIndex = i;
					}
				}
			}
			
			if(maxIndex == arr.length-1) {
				visited[maxIndex] = 1;
			}else
			{
				swap(arr, minIndex, arr.length-1);
				prod+=arr[minIndex];
				minIndex = arr.length-1;
				//then swap maxIndex with minIndex;
				
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String input = s.nextLine();
		String arr_str[] = input.split(" ");
		int n = Integer.parseInt(arr_str[0]);
		int index = Integer.parseInt(arr_str[1]);
		
		String array = s.nextLine();
		String arr_arr[] = array.split(" ");
		
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(arr_arr[i]);
		}
		
		solve(n, index, arr);
	}
}
