package priorityQ;

import java.util.*;

import javafx.util.Pair;
public class PQ<T> {
	
	//MAX_PQ
	T value;
	int priotity;
	int size = 0;
	Vector<Pair<Integer, Integer>> items = new Vector();
	
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
	private int leftChildPriority(int index) {
		return items.get(getLeftChildIndex(index)).getValue();
	}
	private int rightChildPriority(int index) {
		return items.get(getRightChildIndex(index)).getValue();
	}
	private int parentPriority(int index) {
		return items.get(getParentIndex(index)).getValue();
	}
	
	public void _insert(int value, int priority){
		//need to build max heap, for max PQ
		
		Pair<Integer, Integer> pair = new Pair<>(value, priority);
		
		//build_max_heap
		items.add(pair);
		size++;
		max_heapify_up();
		
	}
	
	public Pair<Integer, Integer> _remove_max(){
		
		return _poll();
	}
	
	private Pair<Integer, Integer> _poll(){
		
		Pair<Integer, Integer> max = items.get(0);
		items.set(0, items.get(items.size()-1));
		items.remove(items.size()-1);
		size--;
		_max_heapify_down();
		return max;
	}
	
	private void _max_heapify_down() {
		
		int index = 0;
		while(hasLeftChild(index)) {
			
			int maxIndex = index;
			if(items.get(maxIndex).getValue() < items.get(getLeftChildIndex(index)).getValue()) {
				maxIndex = getLeftChildIndex(index);
			}
			
			if(hasRightChild(index) && items.get(maxIndex).getValue() < items.get(getRightChildIndex(index)).getValue()) {
				maxIndex = getRightChildIndex(index);
			}
			
			if(maxIndex == index) {
				return;
			}
			swap(maxIndex, index);
			index = maxIndex;
		}
		
	}
	private void max_heapify_up() {
		
		int index = size-1;
		while(hasParent(index) && parentPriority(getParentIndex(index)) < items.get(index).getValue()) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	public Pair<Integer, Integer> _get_max(){
		return _peek();
	}
	
	private Pair<Integer, Integer> _peek(){
		
		return items.get(0);
	}
	
	private void swap(int indexOne, int indexTwo) {
		Pair<Integer, Integer> temp = items.get(indexOne);
		items.set(indexOne, items.get(indexTwo));
		items.set(indexTwo, temp);
	}
	
}
