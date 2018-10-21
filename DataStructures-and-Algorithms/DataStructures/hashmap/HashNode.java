package hashmap;

public class HashNode<T> {
	
	String key;
	T value;
	HashNode<T> next;
	
	
	public HashNode(String key, T value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	//destructor not needed here
}