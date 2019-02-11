package Dgraph;
import java.util.*;
public class DiscBfs {
	
	static int vertices, edges;
	static LinkedList<Integer> ll[];
	static int visited[];
	public DiscBfs(int edges){
		//edges = vertices - 1 (min)->specified in question
		this.vertices = edges+1;
		this.edges = edges;
		
		ll = new LinkedList[edges+1];
		
		visited = new int[ll.length];
		for(int i =0; i<ll.length; i++){
			visited[i] = 0;
		}
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}	
	}
	
	public static void addEdge(int a, int b){
		ll[a].add(b);
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
	
	public static void bfs(int start){
		
		int head = start;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()){
			
			int curr = q.poll();
			if(visited[curr] == 0){
				System.out.print(curr+ " ");
				visited[curr] = 1;
			}
			for(int i = 0; i<ll[curr].size(); i++){
				if(visited[ll[curr].get(i)] == 0){
					System.out.print(ll[curr].get(i) + " ");
					q.add(ll[curr].get(i));
					
					visited[ll[curr].get(i)] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int edges = s.nextInt();
		int vertices = edges + 1;
		
		DiscBfs g = new DiscBfs(edges);
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
		}
		
		g.printGraph();
		int start = s.nextInt();
		
		//in case of extra printing, use another array to mark which elemnets are there in graph and loop only those.
		for(int i = 0 ; i<vertices; i++){
			if(visited[i] == 0){
				bfs(i);
			}
		}
	}
}
