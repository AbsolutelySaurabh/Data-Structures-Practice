package cracking_the_code;

import java.util.Scanner;
import java.util.*;
public class RunningMedian {
	private static Scanner s = new Scanner(System.in);
	
	private static int size = 0;
	private static int capacity = 10;
	private static int[] items = new int[capacity];
	
	private static void extraCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity*=2;
		}
	}
	
	private static void swap(int indexOne, int indexTwo) {
		
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private static int parent(int childIndex) {
		return items[getParentIndex(childIndex)];
	}
	
	private static int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	private static boolean hasParent(int index) {
		return (getParentIndex(index) >= 0);
	}
	
	private static int getLeftChildIndex(int index) {
		return 2*index + 1;
	}
	
	private static void heapify_up() {
		int index = size;
		while(hasParent(index) && parent(index) > items[index]) {
			
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private static void add(int num) {
		extraCapacity();
		items[size] = num;
		heapify_up();
		size++;
	}
	

	private static float median() {
		if(size%2!=0) {
			return (float)items[size/2];
		}
		return (float)(items[(size-1)/2] + items[size/2])/2;
	}
	
	public static void main(String[] args) {
		
		int n = s.nextInt();
		while(n>0) {
			
			//do MinHeap
			int num = s.nextInt();
			add(num);
			
			//now calculate the median
			System.out.println(median());
			
			--n;
		}
		//print items
		for(int i=0;i<size;i++) {
			System.out.print(items[i] + " ");
		}
	}
}
