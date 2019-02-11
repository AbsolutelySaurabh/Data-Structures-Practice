package AdjMatrix;

import java.util.Scanner;
public class Stack {

	int top;
	int arr[];
	int capacity = 2;
	int index = 0;
	int size;
	int new_arr[];
	public Stack(){
		
		arr = new int[capacity];
		top = 0;
		size = 0;
		
	}
	
	public void push(int data){
		
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
	
	public int pop(){
		if(top == 0){
			return -1;
		}
		int data = arr[top-1];
		top--;
		return data;
	}
	
	public int get_top(){
		if(top == 0){
			return -1;
		}
		int data = arr[top-1];
		return data;
	}
	public void print(){
		int index = top-1;
		while(index >= 0){
			System.out.print(arr[index] + " ");
			index--;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Stack q = new Stack();
		for(int i = 0; i<n; i++){
			int data = s.nextInt();
			q.push(data);
		}
		q.print();
		for(int i = 0; i<q.size; i++){
			System.out.print(q.pop() + " ");
		}
		int data = s.nextInt();
		q.push(data);
		System.out.println(q.pop());
		
		s.close();
	}
}
