package dummy;
import java.util.*;
public class MergeSort {
	
	public static void merge(int arr[], int l, int mid, int r) {
		
		int left_size = mid-l+1;
		int right_size = r-mid;
		
		int left[] = new int[left_size];
		int[] right = new int[right_size];
		
		for(int i=0; i<left_size; i++) {
			left[i] = arr[l + i];
		}
		
		for(int j = 0;j<right_size; j++) {
			right[j] = arr[mid + j + 1];
		}
		
		//finally
		int k = l, leftIndex = 0, rightIndex = 0;
		while(leftIndex < left_size && rightIndex < right_size) {
			
			if(left[leftIndex]  <= right[rightIndex]) {
				arr[k] = left[leftIndex];
				leftIndex++;
				k++;
			}else
				if(right[rightIndex] <= left[leftIndex]) {
					arr[k] = right[rightIndex];
					rightIndex++;
					k++;
				}
		}
		
		
		while(leftIndex < left.length) {
			arr[k] = left[leftIndex];
			leftIndex++;
			k++;
		}

		while(rightIndex < right.length) {
			arr[k] = right[rightIndex];
			rightIndex++;
			k++;
		}	
		
	}
	
	public static void mergeSort(int arr[], int start, int end) {
		
		if(start < end) {
			
			
			int mid = (start+end-1)/2;
			System.out.println("start : " + start + " end: " + end + " mid : " + mid);
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
			//merge
			merge(arr, start, mid, end);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i <n; i++) {
			arr[i] = s.nextInt();
		}
		
		mergeSort(arr, 0, n-1);
		for(int i=0;i<n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
