package Dgraph;
import java.util.*;
public class Dgraph {

	
	static int vertices;
	static int edges;
	static LinkedList<Integer> ll[];
	
	public Dgraph(int edges){
		this.edges = edges;
		this.vertices = edges+1;
		
		ll = new LinkedList[this.vertices];
		
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int a, int b){
		ll[a].add(b);
	}
	
	public static void printGraph(){
		for(int i = 0; i<ll.length; i++){
			System.out.print(i);
			for(int j = 0; j<ll[i].size(); j++){
				System.out.print(" -> " + ll[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int edges = s.nextInt();
		Dgraph g = new Dgraph(edges);
		
		for(int i = 0; i<edges; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			
			g.addEdge(a, b);
		}
		printGraph();
		s.close();
	}

}
