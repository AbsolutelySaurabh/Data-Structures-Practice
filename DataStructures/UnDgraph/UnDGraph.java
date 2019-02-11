package UnDgraph;
import java.util.*;
public class UnDGraph {
	
	static int v;
	static LinkedList<Integer> ll[];
	public UnDGraph(int edges){
		this.v = edges + 1;
		ll = new LinkedList[edges + 1];
		
		for(int  i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}
	}
	
	//undirected graph
	public static void addEdge(int a, int b){
		ll[a].add(b);
		ll[b].add(a);
		
	}
	
	public static void printGraph(){
		for(int i=0; i<v; i++){
			System.out.print(i);
			for(int j = 0; j<ll[i].size(); j++){
				System.out.print(" -> " + ll[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		UnDGraph g = new UnDGraph(edges);
		for(int i = 0;i<edges; i++){
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			addEdge(a, b);
		}
		printGraph();
	}
	
}