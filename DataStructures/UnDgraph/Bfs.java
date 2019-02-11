package UnDgraph;
import java.util.*;
public class Bfs {
	
	static int vertices, edges;
	static LinkedList<Integer> ll[];
	
	public Bfs(int vertices){
		//edges = vertices - 1 (min)->specified in question
		this.vertices = vertices;
		this.edges = vertices - 1;
		
		ll = new LinkedList[vertices+1];
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
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
	
	public static void bfs(int start){
		
		int head = start;
		int visited[] = new int[ll.length];
		for(int i =0; i<ll.length; i++){
			visited[i] = 0;
		}
		
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
		
		int vertices = s.nextInt();
		int egdes = vertices - 1;
		
		Bfs g = new Bfs(vertices);
		for(int i = 0; i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
		}
		
		g.printGraph();
		int start = s.nextInt();
		bfs(start);
	}

}
