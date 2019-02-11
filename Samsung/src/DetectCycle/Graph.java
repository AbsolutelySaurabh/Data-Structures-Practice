package DetectCycle;

import java.util.Scanner;
public class Graph {

	/*
	 * Detect Cycle in Undirected graph and Directed graph
	 */
	
	int edges, vertices;
	int graph[][];
	int visited[];
	int graph_dir[][];
	int visited_dir[];

	public Graph(int edges){
		
		this.edges = edges;
		this.vertices = edges + 1;
		this.graph = new int[vertices + 1][vertices + 1];
		this.graph_dir = new int[vertices + 1][vertices + 1];

		this.visited = new int[this.vertices + 1];
		this.visited_dir = new int[this.vertices + 1];
	}
	
	public void addEdge(int a, int b){
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	
	public boolean isCyclicUtil(int v, int head){
		visited[v] = 1;
		for(int i = 0; i<graph[v].length; i++){
			if(visited[i] == 0 && graph[v][i] == 1){
				return isCyclicUtil(i, v);
			}else
				if(visited[i] == 1 && graph[v][i] == 1 && i!=head){
					return true;
				}
		}
		return false;
	}
	
	public boolean isCyclic(){
		
		for(int i = 0; i<=this.vertices; i++){
			if(visited[i] == 0){
				if(isCyclicUtil(i, -1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public void print(){
		
		for(int i = 0; i<=this.vertices ; i++){
			System.out.print(i);
			for(int j = 0; j<=this.vertices; j++){
				if(graph[i][j] == 1){
					System.out.print(" ->" + j);
				}
			}
			System.out.println();
		}
	}
	
	public void addEdgeDirected(int a, int b){
		graph_dir[a][b] = 1;
	}
	
	public boolean isCyclicUtilDir(int v, int head){
		visited_dir[v] = 1;
		for(int i = 0; i<graph_dir[v].length; i++){
			if(visited_dir[i] == 0 && graph_dir[v][i] == 1){
				return isCyclicUtil(i, v);
			}else
				if(visited_dir[i] == 1 && graph_dir[v][i] == 1 && i!=head){
					return true;
				}
		}
		return false;
	}
	
	public boolean isCyclicDir(){
		
		for(int i = 0; i<=this.vertices; i++){
			if(visited_dir[i] == 0){
				if(isCyclicUtilDir(i, -1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		Graph g_dir = new Graph(edges);

		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
			g_dir.addEdgeDirected(a, b);
		}
		g.print();
		if(g.isCyclic()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		if(g_dir.isCyclicDir()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		s.close();
	}
}
