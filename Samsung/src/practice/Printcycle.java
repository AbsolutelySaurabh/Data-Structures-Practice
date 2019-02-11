package practice;

import java.util.Scanner;

public class Printcycle {
	
	/*
	 * Print cycle in Undirected and Directed graph in sorted order
	 */

	static class Graph{
		
		int graph[][];
		int edges, vertices;
		int visited[];
		int color[];
		boolean isCycle;
		int parent[];
		int cycleNumber;
		
		public Graph(int edges){
			this.edges = edges;
			this.vertices = edges+1; //max
			this.visited = new int[this.vertices+1];
			this.graph = new int[this.vertices+1][this.vertices+1];
			this.color = new int[this.vertices+1];
			this.parent = new int[this.vertices+1];
		}
		
		public void addEdge(int a, int b){
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		public void printCycle(int src, int p){
			
			visited[src] = 1;
			int v = -1;
			color[src] = 1; //grey
			parent[src] = p;
			for(int i = 1; i<this.graph.length; i++){
				if(graph[src][i] == 1 && color[i] == 0){
					printCycle(i, src);
				}else
					if(graph[src][i] == 1 && color[i] == 1 && p!=i){
						//cycle detected
						v = i;
						isCycle = true;
						cycleNumber++;
						if(isCycle){	
							//print it
							if(isCycle){
								print(src, v);
								isCycle = false;
							}
						}
						//break;
					}	
			}
			color[src] = 2;//black marked
		}
		
		int cl_arr[];
		public void sort(int cL){
			
			//apply selection sort
			for(int i = 0; i<cL-1; i++){
				int min = cl_arr[i];
				for(int j = i+1; j<cL; j++){
					if(cl_arr[j] < min){
						min = cl_arr[j];
						
						int temp = cl_arr[i];
						cl_arr[i] = cl_arr[j];
						cl_arr[j] = temp;
					}
				}
			}
			
		}
		
		public void print(int u, int v){
			
			System.out.print("cycle number " + cycleNumber + ": ");
			int cycleLength = 0;
			int index = 0;
			int cycle_arr[] = new int[this.vertices+1];
			while(u!=v){
				//System.out.print(u + " ");
				cycle_arr[index] = u;
				index++;
				u = parent[u];
				cycleLength++;
			}
			//System.out.print(u + " ");
			cycle_arr[index] = u;
			cycleLength++;
			cl_arr = cycle_arr;
			
			//sort it using selection sort
			sort(cycleLength);
//			System.out.println("Sorted: ");
			for(int i = 0; i<cycleLength; i++){
				System.out.print(cl_arr[i] + " ");
			}
		}
		
	};
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		Graph g = new Graph(edges);
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
		}
		g.printCycle(1, -1);
		
	}
}