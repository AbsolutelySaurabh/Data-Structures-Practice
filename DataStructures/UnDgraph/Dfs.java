package UnDgraph;

import java.util.*;
public class Dfs {
	
	public static int edges, vertices;
	public static LinkedList<Integer> ll[];
	public static int visited[];

	public Dfs(int edges){
		
		this.edges = edges;
		this.vertices = edges + 1;
		
		ll = new LinkedList[this.vertices];
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}
		
		visited = new int[this.vertices];
		for(int i = 0; i<visited.length; i++){
			visited[i] = 0;
		}
	}
	
	public Dfs(int vertices, int edges){
		
		this.edges = edges;
		this.vertices = vertices + 1;
		
		ll = new LinkedList[this.vertices];
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}
		
		visited = new int[this.vertices];
		for(int i = 0; i<visited.length; i++){
			visited[i] = 0;
		}
	}
	
	public static void addEdge(int a, int b){
		ll[a].add(b);
		ll[b].add(a);
	}
	
	public static void printGraph(){
		for(int i = 0; i<ll.length-1; i++){
			System.out.print(i);
			for(int j = 0; j<ll[i].size(); j++){
				System.out.print(" -> " + ll[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void dfs(int head){
		
		if(visited[head] == 1){
			return;
		}
		visited[head] = 1;
		System.out.print(head + " -> ");
		for(int i = 0; i<ll[head].size(); i++){
			int num = ll[head].get(i);
			if(visited[num] == 0){
				dfs(num);
			}
		}
	}
	
	public static void dfs_disconnected(int v, int e){
		
		
		/**
		In this case : the number of vertices should be entered
		Since, for fully connected graph only, vertices = edges + 1;
		**/
		
		/**
		 * In this case of disconnected graph,
		 * We need to make each node as head, one by one and then perform dfs, as a node might not be reachable from head
		 */
		
		for(int i = 0; i<v; i++){
			
			if(visited[i] == 0){
				dfs(i);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
//		int edges = s.nextInt();
//		int vertices = edges + 1;
//
//		Dfs g = new Dfs(edges);
//		for(int i = 0; i<edges; i++){
//			int a = s.nextInt();
//			int b = s.nextInt();
//			addEdge(a, b);
//		}
//		
//		printGraph();
//		System.out.println();
//		//apply dfs
//		dfs(0);
		
		System.out.println("DFS disconnected graph");
		int v = s.nextInt();
		int e = s.nextInt();
		Dfs g2 = new Dfs(v, e);
		for(int i = 0; i<e; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			addEdge(a, b);
		}
		printGraph();
		dfs_disconnected(v, e);
	}
}
