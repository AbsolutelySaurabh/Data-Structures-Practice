package BellmanFord;

import java.util.*;
public class Graph {
	/*
	 * Bellman ford:
	 * 1. Apply relaxation on all edges.
	 * 2. Advantage : It works for negative edges too, except cycle when sum(all weight) < 0
	 */
	
	class Edge{
		int first;
		int second;
		int weight;
		public Edge(int first, int second, int weight){
			this.weight = weight;
			this.first = first;
			this.second = second;
		}
	};
	
	int cost[][];
	int edges, vertices;
	int visited[];
	int max = 100000007;
	int edge_index = 0;
	Edge edge_arr[];
	
	public Graph(int edges){
		this.edges = edges;
		this.vertices = edges + 1;
		
		this.cost = new int[this.vertices][this.vertices];
		this.visited = new int[this.vertices];
		
		edge_arr = new Edge[edges];
	}
	
	public void addEdge(int a, int b, int weight){
		edge_arr[edge_index] = new Edge(a, b, weight);
		edge_index++;
	}
	
	public void printEdges(){
		for(int i = 0; i<edge_arr.length; i++){
			System.out.print(" " + edge_arr[i].first + " -> " + edge_arr[i].second + " = " + edge_arr[i].weight + " , ");
		}
	}
	
	/*
	 * Apply Belmann ford algorithm:
	 * 1. Perform relaxation on all the edges;
	 * 2. repeat the above step for all the edges
	 */
	int dis[];
	public void applyBellman(int source){
		
		//visited
		//dis[]
		dis = new int[this.vertices];
		for(int i = 0; i<dis.length; i++){
			dis[i] = max;
		}
		dis[source] = 0;
		
		//repeat this [V-1] times
		for(int v = 1; v<this.vertices; v++){
			for(int i = 0; i<edge_arr.length; i++){
				
				int src = edge_arr[i].first;
				int des = edge_arr[i].second;
				int w = edge_arr[i].weight;
				
				if(dis[src] + w < dis[des]){
					dis[des] = dis[src] + w;
				}
			}
		}
		
		//did first one for all the edges
		
		/*
		 * CHECK DRAWBACK: We have to check the cycle in the end, if exsist then it can't be solved by Bellman ford which is DRAWBACK;
		 * How : simple check this by if anywhere dis[u] + weight < dis[v];
		 */
		for(int i = 0; i<edge_arr.length; i++){
			int src = edge_arr[i].first;
			int des = edge_arr[i].second;
			int w = edge_arr[i].weight;
			
			if(dis[src] + w < dis[des]){
				System.out.println("Graph contains negative weight cycle.");
			}
		}
		
		printDis();
	}
	
	public void printDis(){
		System.out.println();
		for(int i = 1; i<dis.length; i++){
			System.out.print(dis[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g  =  new Graph(edges);
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			int weight = s.nextInt();
			
			g.addEdge(a, b, weight);
		}
		g.printEdges();
		g.applyBellman(1);
		s.close();
	}
}