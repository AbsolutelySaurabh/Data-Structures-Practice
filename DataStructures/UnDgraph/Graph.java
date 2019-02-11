package UnDgraph;

import java.util.*;

public class Graph {
	
	class Vector<T> {
		
		int data;
		int size;
		int capacity = 2;
		int arr[];
		int index = 0;
		int new_arr[];
		
		public Vector(){
			
			arr = new int[capacity];
		}
		
		public void add(int data){
			
			if(this.index >= this.capacity){
				this.capacity+=2;
				this.new_arr = new int[this.capacity];
				for(int i = 0; i<this.arr.length; i++){
					this.new_arr[i] = arr[i];
				}
				this.arr = new int[this.capacity];
				this.arr = this.new_arr;
			}
			this.arr[this.index] = data;
			this.index++;
			this.size++;
			
		}
		
		public int get(int index){
			
			if(index > this.size){
				return -1;
			}
			return this.arr[index];
		}
	};
	
	Vector<Vector<Integer>> ll[];
	int edges, vertices;
	
	public Graph(int edges){
		
		this.edges = edges;
		this.vertices = edges+1;
		
		ll = new Vector[this.vertices+1];
		for(int i = 0; i<ll.length; i++){
			
			ll[i] = new Vector();
		}
	}
	
	public void addEdge(int a, int b){
		
		ll[a].add(b);
		ll[b].add(a);
	}
	
	public void print(){
		for(int i = 1; i<ll.length-1; i++){
			
			/*
			 * In case of N+1 > vertices (edges+1), this will print extra vertex (i)
			 * To handle this, we can use if(ll[i].size > 0) but this will not handle the isolated vertex case.
			 * To handle isolated vertex case : use the above line condition along with any array to mark the presence of that vertex in graph 
			 */
			System.out.print(i);
			
			for(int  j = 0; j<ll[i].size; j++){
				System.out.print(" -> " + ll[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		for(int  i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
		}
		g.print();
	}

}
