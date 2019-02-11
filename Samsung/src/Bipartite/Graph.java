package Bipartite;

import java.util.*;
public class Graph {

	/*
	 * Bipartite : A graph is Bipartite, if it can be colored with 2 colors only, i.e. no same color on 1 edge.
	 * 			   Also, if cycle has even number of vertices then bipartite, if odd then not bipartite.
	 * 
	 * 			   In, UNDIRECTED graph
	 * 
	 * Extra     : Print the cycle, in sorted order
	 */
	
	int graph[][];
	int color[];
	int edges;
	int vertices;
	int parent[];
	int cycle_number;
	boolean isBipartite;
	int arr_v[]; //to store the cycled vertices
	int arr_v_index;
	
	public Graph(int edges){
		
		this.edges = edges;
		this.vertices = edges + 1;
		this.color = new int[this.vertices + 1];
		this.graph = new int[this.vertices + 1][this.vertices + 1];
		this.parent = new int[this.vertices + 1];
		this.cycle_number = 0;
		this.isBipartite = true;
		this.arr_v = new int[this.vertices+1];
		this.arr_v_index = 0;
	}
	
	public void addEdge(int a, int b){
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	
	public void dfs(int v, int head){
		
		//if has been proved not bipartite, as any cycle is of odd length, then return
		if(this.isBipartite == false){
			return;
		}
		
		color[v] = 1; //grey
		boolean isCyclic = false;
		parent[v] = head;
		int ver = 0;
		for(int i = 1; i<=vertices; i++){
			
			if(this.isBipartite == false){
				return;
			}
			
			if(graph[v][i] == 1 && color[i] == 0){
				//parent[i] = v;
				dfs(i, v);
			}else
				if(graph[v][i] == 1 && color[i] == 1 && head!=i){
					//cycle exists
					isCyclic = true;
					ver = i;
					cycle_number++;
					break;
				}
		}
		color[v] = 2; // colored black, where cycle detected
		if(isCyclic == true){
			printCycle(v, ver);
			if(this.isBipartite == false){
				return;
			}
		}
	}
	
	public void sort(){
		
		/*
		 * Sorting : Selection sort
		 */
		System.out.println("arr v length: " + arr_v_index);
		for(int i = 0; i<arr_v_index-1; i++){
			
			int min = arr_v[i];
			System.out.print("min: " + min);
			for(int j = i+1; j<arr_v_index; j++){
				if(arr_v[j] < min){
					
					min = arr_v[j];
					//swap
					int temp = arr_v[i];
					arr_v[i] = arr_v[j];
					arr_v[j] = temp;
					
				}
			}
		}
		
	}
	
	public void printCycle(int u, int v){
		
		int cycleLength = 0;
		System.out.println("cycleNumber: " + cycle_number);
		while(u!=v){
			System.out.print(u + " ");
			
			arr_v[arr_v_index] = u;
			arr_v_index++;
			
			u = parent[u];
			cycleLength++;
		}
		System.out.print(u);
		arr_v[arr_v_index] = u;
		arr_v_index++;
		
		System.out.println();
		cycleLength++;
		System.out.println("cycleLength: " + cycleLength);
		
		/*
		 * Based on cycleLength, Bipartite, can be decided, if (all even = YES)
		 */
		if(cycleLength%2 != 0){
			this.isBipartite = false;
			System.out.println("NO");
		}
		cycleLength = 0;//reset for next cycle

		/*
		 * Sort the cycle vertices, and print
		 */
		sort();
		System.out.println("After sorting: ");
		for(int i = 0; i<arr_v_index; i++){
			System.out.print(arr_v[i] + " ");
		}
		for(int i = 0; i<arr_v_index; i++){
			arr_v[i] = 0;
		}
		arr_v_index = 0;
	}
	
	public void dfs_util(){
		
		for(int i = 1; i<=vertices; i++){
			if(color[i] == 0){
				dfs(i, -1);
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
			
			g.addEdge(a,  b);
		}
		
		g.dfs_util();
		if(g.isBipartite == true){
			System.out.println("YES");
		}
		s.close();
	}
}