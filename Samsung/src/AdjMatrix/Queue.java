package AdjMatrix;

import java.util.Scanner;

public class Queue {

	int top, bottom;
	int arr[];
	int capacity = 2;
	int index = 0;
	int size;
	int new_arr[];
	public Queue(){
		
		arr = new int[capacity];
		top = 0;
		bottom = 0;
		size = 0;
		
	}
	
	public void enq(int data){
		
		if(top >= capacity){
			capacity+=10;
			new_arr = new int[capacity];
			for(int i = 0; i<arr.length; i++){
				new_arr[i] = arr[i];
			}
			arr = new int[capacity];
			arr = new_arr;
		}
		arr[top] = data;
		top++;
		size++;
	}
	
	public int deq(){
		if(top <= bottom){
			return -1;
		}
		int data = arr[bottom];
		bottom++;
		return data;
	}
	
	public int get_top(){
		if(top <= bottom){
			return -1;
		}
		int data = arr[top-1];
		return data;
	}
	public void print(){
		int index = top-1;
		while(index > bottom){
			System.out.print(arr[index] + " ");
			index--;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Queue q = new Queue();
		for(int i = 0; i<n; i++){
			int data = s.nextInt();
			q.enq(data);
		}
		q.print();
		for(int i = 0; i<q.size; i++){
			System.out.print(q.deq() + " ");
		}
		int data = s.nextInt();
		q.enq(data);
		System.out.println(q.deq());
		
		s.close();
	}
}
