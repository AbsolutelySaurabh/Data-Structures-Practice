package UnDgraph;

import java.util.*;

public class Vector {
	
	int data;
	static int size;
	static int capacity = 2;
	static int arr[];
	static int index = 0;
	static int new_arr[];
	
	public Vector(){
		
		arr = new int[this.capacity];
	}
	
	public static void add(int data){
		
		if(index >= capacity){
			capacity+=2;
			new_arr = new int[capacity];
			for(int i = 0; i<arr.length; i++){
				new_arr[i] = arr[i];
			}
			arr = new int[capacity];
			arr = new_arr;
		}
		arr[index] = data;
		index++;
		size++;
		
	}
	
	public static int get(int index){
		
		if(index > size){
			return -1;
		}
		
		return arr[index];
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Vector v = new Vector();
		for(int i = 0; i<n; i++){
			
			int a = s.nextInt();
			add(a);
		}
		int index = s.nextInt();
		System.out.println(get(index));
	}

}
