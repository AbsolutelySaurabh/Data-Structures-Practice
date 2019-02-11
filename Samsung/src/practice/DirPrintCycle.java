package practice;

import java.util.*;
public class DirPrintCycle {
	
	/*
	 * Detect and print cycle in Directed graph : It also handles self-loop
	 */
	
	int graph[][];
	int vertices, edges;
	int visited[];
	int parent[];
	int recur[];
	boolean isCycle;
	
	public DirPrintCycle(int edges){
		this.edges = edges;
		this.vertices = edges+1;
		this.visited= new int[this.vertices+1];
		this.parent = new int[this.vertices+1];
		this.graph  = new int[this.vertices+1][this.vertices+1];
		this.recur = new int[this.vertices+1];
		this.isCycle = false;
	}
	
	public void addEdge(int a, int b){
		graph[a][b] = 1;
	}
	
	public void detectCycleUtil(int src, int p){
		
		if(recur[src] == 1){
			//if recursion stack = 1, then already in rec_stack[] so cycle present
			isCycle = true;
			return;
		}
		if(visited[src] == 1){
			//this is applicable for the case when, 1 --> 4, 1 --> 2, 2 --> 4, 3 --> 1, 2 --> 3
			isCycle = false;
			return;
		}
		int v = -1;
		recur[src] = 1;
		visited[src] = 1;
		parent[src] = p;
		for(int i = 1; i<=this.vertices; i++){
			
			if(graph[src][i] == 1){
				
				detectCycleUtil(i, src);
				if(isCycle){
					//cycle detected at this source
					v = i;
					if(isCycle){
						//print cycle
						print(src, v);
						isCycle = false;
					}
					//break;
				}
			}
		}
		//remove the current from recurStack as going back in recur
		recur[src] = 0;
	}
	
	public void print(int u, int v){
		
		int cycleLength = 0;
		int index = 0;
		int cycle_arr[] = new int[this.vertices+1];
		while(u!=v){
			System.out.print(u + " ");
			cycle_arr[index] = u;
			index++;
			u = parent[u];
			cycleLength++;
		}
		System.out.print(u + " ");
		cycle_arr[index] = u;
		cycleLength++;
		System.out.println();

	}
	
	public void detectCycle(){
		
		for(int i = 1; i<=this.vertices; i++){
			if(visited[i] == 0){
				detectCycleUtil(i, -1);
				//System.out.println("i: " + i);
			}
		}
		return;
	}
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		DirPrintCycle c = new DirPrintCycle(edges);
		for(int i = 0; i<edges; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			
			c.addEdge(a, b);
		}
		c.detectCycle();
		s.close();
	}

}
