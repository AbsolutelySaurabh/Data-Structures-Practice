package graph;

public class GraphUse {
	
	public static void main(String[] args0) {
		
		Graph g = new Graph();
		
		int a = 1, b = 2;
		
		g.addVertex(a);
		g.addVertex(b);
		
		g.addEdge(a, b);
		
		g.print();
				
	}
}
