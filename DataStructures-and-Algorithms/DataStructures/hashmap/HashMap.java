package hashmap;

import java.util.Vector;

public class HashMap<T> {
	
	//we need a buckets to store the values
	 Vector<HashNode<T>> buckets = new Vector<HashNode<T>>();
	 int numElements = 0;
	 int initialSize = 1;
	
	/**
	 * @param 31, 33, 37, 39, 41
		If you take over 50,000 English words (formed as the union of the word lists
		provided in two variants of Unix), using the constants 31, 33, 37, 39, and 41 will produce less than 7 collisions in each case. 
		Knowing this, it should come as no surprise that many Java implementations choose one of these constants.
	 **/
	 
	public int getIndex(String key) {
		
		int size = key.length()-1;
		int currIndex = size;
		int currentPower = 1;
		int index = 0;
		while(currIndex>=0) {
			   
			index = key.charAt(currIndex)*currentPower;
			currentPower*=37;
			currIndex--;
		}
		
		System.out.println("index: " + index);
		//not make it till the table size
		return index%initialSize;
		
	}
	
	public void add(String key, T value) {
		
		//find index
		int index = getIndex(key);
		//create head and temp
		HashNode<T> head = buckets.get(index);
		HashNode<T> temp = head;
		
		HashNode<T> newNode = new HashNode<T>(key, value);
		
		//check if key is already present
		while(temp!=null) {
			
			if(temp.key.equals(key)) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		
		//then put the created new one at the front
		newNode.next = head;
		head = newNode;
		numElements++;
		
		buckets.set(index, head);
		
		//not need of reHashing here, and loadFactor as we're using vector here
	}
	
	//search, returns value
	public T get(String key) {
		
		int index = getIndex(key);
		HashNode<T> head = buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)){
				return head.value;
			}
			head = head.next;
		}
		return (T)"-1";
	}
	
	
}
