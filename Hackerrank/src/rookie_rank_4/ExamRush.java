package Algos;

import java.util.Scanner;

public class ExamRush {

	public static int rush(int[] arr, int n, int hours) {
		int count = 0;
		quicksort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++) {
			if(hours - arr[i] >= 0) {
				count++;
				hours-=arr[i];
			}
		}
		return count;
	}
	
	static void swap(int[] arr, int i, int pIndex) {
		int temp = arr[i];
		arr[i] = arr[pIndex];
		arr[pIndex] = temp;
	}
	
	static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		//pIndex = partitionIndex
		int pIndex = start;
		for(int i=start;i<end;i++) {
			if(arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		//finally swap pivot with the pIndex;
		swap(arr, pIndex, end);
		return pIndex;
	}
	
	static void quicksort(int[] arr, int start, int end) {
		
		if(start<end) {
			
			//we'll choose pivot and partition the array
			int pIndex = partition(arr, start, end);
			
			quicksort(arr, start, pIndex-1);
			quicksort(arr, pIndex+1, end);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		int hours = s.nextInt();
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println(rush(arr, n, hours));
		
	}

}
