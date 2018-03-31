package heap;

import java.util.Scanner;

public class HeapSort {

	private static Scanner s = new Scanner(System.in);
	private static int[] items;
	private static int lastElement;
	
	private static void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private static void build_max_heap() {
		
		double index = items.length/2-1;
		//index = Math.floor(index);
		while(index >= 0) {
			
			max_heapify((int)index, items.length);
			--index;
		}
	}
	
	private static void max_heapify(int index, int length) {
		
		while(index < length) {
			
			int maxIndex = index;
			int leftChildIndex = 2*index + 1;
			int rightChildIndex = leftChildIndex+1;
			
			if(leftChildIndex < length && items[leftChildIndex] > items[maxIndex]) {
				maxIndex = leftChildIndex;
			}
			
			if(rightChildIndex < length && items[rightChildIndex] > items[maxIndex]) {
				maxIndex = rightChildIndex;
			}
			
			if(maxIndex == index) {
				return;
			}
			
			swap(index, maxIndex);
			index = maxIndex;
		}
	}
	
	//Time complexity: O( NlogN )
	private static void heapSort() {
		
		//Time complexity: O(n)
		build_max_heap();

		lastElement = items.length-1;
		while(lastElement > 0) {
			
			swap(lastElement, 0);
			//Time complexity: O(logN)
			max_heapify(0, lastElement);
			lastElement-=1;
		}
	}

	
	public static void main(String[] args) {
		
		int n = s.nextInt();
		items = new int[n];
		for(int i=0;i<n;i++) {
			items[i] = s.nextInt();
		}
		heapSort();
		
		System.out.println("after Heap sort: ");
		for(int i=0;i<n;i++) {
			System.out.print(items[i] + " ");
		}
		
	}
}
