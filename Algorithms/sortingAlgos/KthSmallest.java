package sortingAlgos;

import java.util.Scanner;

public class KthSmallest {

	//This solution solves in Linear time, unlike O(nLogn) algorithm
	
	//the idea if just quick sort + check is kth pivot is there
	
	public static int partition(int arr[], int start, int end) {
		
		int pivot = arr[end];
		int pIndex = start;
		for(int i=start; i<end; i++) {
			if(arr[i] <= pivot) {
				int temp  = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		//swap pIndex and pivot
		int temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp;
		
		return pIndex;
	}
	
	public static int kthSmallest(int arr[], int start, int end, int k) {
		
		if(start < end) {
			int pivotIndex = partition(arr, start, end);
			if(k-1 == pivotIndex) {
				return arr[pivotIndex];
			}
			//check if l<pivotIndex, then check i left array for smallest, cz the element smaller then piVot is in th eft array
			if(k<pivotIndex) {
				return kthSmallest(arr, start, pivotIndex-1, k);
			}
			return kthSmallest(arr, pivotIndex+1, end, k);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			
			int n = s.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
			}
			int k = s.nextInt();
			
			System.out.println(kthSmallest(arr, 0, n-1, k));
			t--;
		}
		s.close();
	}

}
