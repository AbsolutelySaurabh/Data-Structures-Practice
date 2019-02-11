package PrintCycle;

import java.util.*;
public class Graph {

	/*
	 *Print Cycle in sorted order.
	 *Used Selection sort
	 */
	
	int graph[][];
	int color[];
	int edges;
	int vertices;
	int parent[];
	int cycle_number;
	int arr_v[]; //to store the cycled vertices
	int arr_v_index;
	
	public Graph(int edges){
		
		this.edges = edges;
		this.vertices = edges + 1;
		this.color = new int[this.vertices + 1];
		this.graph = new int[this.vertices + 1][this.vertices + 1];
		this.parent = new int[this.vertices + 1];
		this.cycle_number = 0;
		this.arr_v = new int[this.vertices+1];
		this.arr_v_index = 0;
	}
	
	public void addEdge(int a, int b){
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	
	public void dfs(int v, int head){
		
		color[v] = 1; //grey
		boolean isCyclic = false;
		parent[v] = head;
		int ver = 0;
		for(int i = 1; i<=vertices; i++){

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
		s.close();
	}
}