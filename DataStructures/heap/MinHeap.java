package heap;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {
		
	static int size = 0;
	static int capacity = 10;
	static int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex + 1;
	}
	private int getRightChildIndex(int parentIndex) {
		return 2*parentIndex + 2;
	}
	private static int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	private static boolean hasParent(int index) {
		return getParentIndex(index)>=0;
	}
	
	
	@SuppressWarnings("unused")
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	private static int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	
	private static void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	private static void ensureExtraCapacity() {
		if(size == capacity) {
			//create a new copy of existing array with double capacity
			//thats how arrayList works
			items = Arrays.copyOf(items, capacity*2);
			capacity*=2;
		}
	}
	
	@SuppressWarnings("unused")
	private int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	//remove and returns the top element and replace it with the last one, it the minimum one
	@SuppressWarnings("unused")
	private int poll() {
		if(size == 0) throw new IllegalStateException();
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
		
	}
	
	private static void add(int num) {
		
		ensureExtraCapacity();
		items[size] = num;
		heapifyUp();
		size++;
	}
	
	private static void heapifyUp() {
		
		int index = size;
		//now to heapify up after adding at the last4
		while(hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		 int index = 0;
		 //check until hasLeftChild(index)
		 while(hasLeftChild(index)) {
			 
			 int minIndex = getLeftChildIndex(index);
			 if(hasRightChild(index) && rightChild(index) < items[minIndex]) {
				 minIndex = getRightChildIndex(index);
			 }
			 
			 //if at any point
			 if(items[index] < items[minIndex]) {
				 break;
			 }
			 
			 swap(index, minIndex);
			 index = minIndex;
		 }
	}
	
	private static float median() {
		if(size%2!=0) {
			return (float)items[size/2];
		}
		return (float)(items[(size-1)/2] + items[size/2])/2;
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
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
		s.close();
	}
}

