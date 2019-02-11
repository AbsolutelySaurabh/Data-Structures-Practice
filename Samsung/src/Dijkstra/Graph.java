package Dijkstra;

import java.util.*;
public class Graph {
	
	/*
	 * Dijkstra algorithm for directed graph
	 */
	
	class Pair{
		int vertex;
		int weight;
		
		public Pair(int vertex, int weight){
			this.weight = weight;
			this.vertex = vertex;
		}
	};

	int graph[][];
	int edges, vertices;
	int visited[];
	int max = 100000007;
	int isVertexPresent[];

	int dis[];
	public Graph(int edges){
		this.edges = edges;
		this.vertices = this.edges + 1;
		graph = new int[this.vertices][this.vertices];
		visited = new int[this.vertices + 1];
		this.dis = new int[this.vertices+1];
		isVertexPresent = new int[this.vertices + 1];
	}
	
	public void addEdge(int a, int b, int w){
		graph[a][b] = w;
	}
	
	boolean all_visited = false;
	int source = 1;
	public void dijkstra(){
		
		//from source vertex lets's  = 1
		
		/*
		 * 1. make dis[] from source
		 * 2. find min dis[] vertex
		 * 3. perform bfs, and relax
		 * repeat until any non-visited left
		 */
		
		//fill the dis vertex from source graph[source][i];
		int index = 0;
		graph[source][source] = 0;
		for(int j = 1; j<graph[source].length; j++){
			if(graph[source][j]!=0){
				dis[j] = graph[source][j];
			}else{
				//no direct edge exist
				dis[j] = max;
			}
		}
		dis[source] = 0;
		printDis();
		
		///repeat for all vertices
		for(int i = 1; i<= this.vertices; i++){ 
			if(this.isVertexPresent[i] == 1){
				//find minimum
				int min_index = findMinWvertexIndex();
				if(min_index!=-1){
					
					relax(min_index);
					visited[i] = 1;
				}
			}
		}
		printDis();
	}
	
	public void printDis(){
		for(int i = 0; i<dis.length; i++){
			if(this.isVertexPresent[i] == 1){
				System.out.print(" weight: " + dis[i] + "-->" + "vertex: " + i);
			}
		}
		System.out.println();
	}
	
	public void relax(int min_index){
		
		//perform bfs on min and relax adjacent vertices
		for(int j = 1; j<graph[min_index].length; j++){
			if(this.isVertexPresent[j] == 1 && visited[j] == 0 && graph[min_index][j]!=0){
				if(dis[min_index] + graph[min_index][j] < dis[j]){
					dis[j] = dis[min_index] + graph[min_index][j];
				}
			}
		}
		
	}
	
	public int findMinWvertexIndex(){
		int min = max;
		int min_index = -1;
		for(int i = 1; i<dis.length; i++){
			if(this.isVertexPresent[i] == 1){
				if(visited[i] == 0){
					if(dis[i] < min){
							min_index = i;
							min = dis[i];
					}
				}
			}
		}
		return min_index;
	}
	
	public void printG(){
		
		for(int i = 1; i<graph.length; i++){
			if(this.isVertexPresent[i] == 1){
				System.out.print(i + " -> ");
			}
			for(int j = 1; j<graph[i].length; j++){
				if(this.isVertexPresent[j] == 1){
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		for(int i = 0; i<edges; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.isVertexPresent[a] = 1;
			g.isVertexPresent[b] = 1;
			int weight = s.nextInt();
			g.addEdge(a, b, weight);
		}
		g.printG();
		g.dijkstra();
		s.close();
	}
}