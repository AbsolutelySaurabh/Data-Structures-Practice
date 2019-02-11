package Bfs;

import java.util.*;
public class Graph {
	
	class Queue{
		
		int top, bottom;
		int arr[];
		int new_arr[];
		int capacity, size, index;
		
		public Queue(){
			this.capacity = 5;
			this.size = 0;
			this.index = 0;
			
			arr = new int[capacity];
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
			size--;
			return data;
		}
		
		public int get_top(){
			if(top == 0){
				return -1;
			}
			return arr[top-1];
		}
	};
	
	int edges, vertices;
	int graph[][];
	int visited[];
	int isNodePresent[]; //just to avoid the traversing of non-present node;
	
	public Graph(int edges){
		this.edges = edges;
		this.vertices = edges+1;
		this.graph = new int[this.vertices+1][this.vertices+1];
		this.visited = new int[this.vertices + 1];
		this.isNodePresent = new int[this.vertices+1];
	}
	
	public void addEdge(int a, int b){
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	
	public void print(){
		for(int i = 0; i<graph.length; i++){
			if(isNodePresent[i] == 1){
				System.out.print(i);
			}
			for(int j = 0;j <graph[i].length; j++){
				if(graph[i][j] == 1){
					System.out.print(" -> " + j);
				}
			}
			System.out.println();
		}
	}
	
	public void bfs_util(int v){
		
		Queue q = new Queue();
		Scanner s = new Scanner(System.in);
		q.enq(v);
		this.visited[v] = 1;
		while(q.size!=0){
			
			int vertex = q.deq();
			System.out.print(vertex + " -> ");
			for(int j = 0; j<graph[vertex].length; j++){
				if(graph[vertex][j] == 1 && this.visited[j] == 0){
					this.visited[j] = 1;
					q.enq(j);
				}
			}
			
		}
		s.close();
	}
	
	public void bfs(){
		for(int i = 1; i<=this.vertices; i++){
			if(this.visited[i] == 0 && this.isNodePresent[i] == 1){
				bfs_util(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		for(int i = 0; i<edges; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			g.isNodePresent[a] = 1;
			g.isNodePresent[b] = 1;
			g.addEdge(a, b);
		}
		g.print();
		g.bfs();
		
		s.close();
	}
}