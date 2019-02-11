package UnDgraph;

import java.util.*;
public class PrintCycle {
	
	/*
	 * Detect and Print cycle in an undirected graph
	 * 
	 * Algorithm:
	 * Use recursion stack and visited[] to detect and print cycle.
	 */
	
	public static int edges, vertices;
	public static LinkedList<Integer> ll[];
	public static int visited[];
	
	public PrintCycle(int edges){
		
		this.edges = edges;
		this.vertices = edges + 1;
		
		ll = new LinkedList[this.vertices+1];
		visited = new int[this.vertices + 1];
		for(int i = 0; i<visited.length; i++){
			visited[i] = 0;
		}
		
		for(int i= 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}
	}
	
	public static void addEdge(int a, int b){
		ll[a].add(b);
		ll[b].add(a);
	}
	
	public static boolean isCyclic(int v, int head){
		
		visited[v] = 1;
		for(int i = 0; i<ll[head].size(); i++){
			
			if(visited[i] == 0){
				return isCyclic(i, v);
			}else
				if(head!=i){
					return true;
				}
			
		}
		return false;
	}
	
	public static boolean isCyclicUtil(){
		
		for(int i = 1; i<=vertices; i++){
			
			if(visited[i] == 0){
				
				if(isCyclic(i, -1)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	public static void printCycle(int v, Stack<Integer> rstack){
		
		visited[i] = 1;
		rstack.push(item)
	}
	
	public static void printCycleUtil(){
		
		for(int i = 0; i<visited.length; i++){
			visited[i] = 0;
		}
		
		Stack<Integer> rstack = new Stack<Integer>();
		for(int i = 1; i<=vertices; i++){
			
			if(visited[i] == 0){
				
				printCycle(i, rstack);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		PrintCycle g = new PrintCycle(edges);
		
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			addEdge(a, b);
		}
		if(isCyclicUtil()){
			
			//print cycle
			printCycle();
		}
	}
}