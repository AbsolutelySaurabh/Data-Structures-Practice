package AdjMatrix;

import java.util.*;
public class Graph {
	
	/*
	 * 1. Graph implementation by Adjacency matrix
	 * 2. DFS
	 */
	
	public static int edges, vertices;
	public static int ll[][]; //default value is = 0, no need to initialize
	public static int ll_dir[][];
	public static int visited[];
	public Graph(int edges){
		
		this.edges = edges;
		this.vertices = edges+1;
		
		ll = new int[this.vertices][edges + 1];
		ll_dir = new int[this.vertices][edges + 1];
		
		visited = new int[ll.length+1];
	}
	
	public static void addEdge(int a, int b){
		ll[a][b] = 1;
		ll[b][a] = 1;
	}
	
	public static void print(){
		for(int i = 0; i<ll.length; i++){
			
			System.out.print(i);
			for(int j = 0; j<ll[i].length; j++){
				if(ll[i][j] == 1){
					System.out.print(" -> " + j);
				}
			}
			System.out.println();
		}
	}
	public static void printDir(){
		for(int i = 0; i<ll_dir.length; i++){
			
			System.out.print(i);
			for(int j = 0; j<ll_dir[i].length; j++){
				if(ll_dir[i][j] == 1){
					System.out.print(" -> " + j);
				}
			}
			System.out.println();
		}
	}
	
	public static void addEdgeDir(int a, int b){
		ll_dir[a][b] = 1;
	}
	
	public static void unD_dfs(int v){
		
		visited[v] = 1;
		System.out.print(v + " -> ");
		for(int j = 1; j<ll[v].length; j++){
			if(ll[v][j] == 1 && visited[j] == 0){
				unD_dfs(j);
			}
		}
	}
	
	public static void und_dfs_util(){
		
		for(int i = 1; i< vertices; i++){
			
			if(visited[i] == 0){
				unD_dfs(i);
			}	
		}
	}
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			addEdge(a, b);
			addEdgeDir(a, b);
		}
		print();
		printDir();
		
		//dfs
		System.out.println("DFS: ");
		und_dfs_util();
		
		s.close();
	}
}