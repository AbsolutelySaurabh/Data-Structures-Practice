package graph;

public class Bfs {
	
	public static void print(Graph g) {
		
		for(int i=0; i<g.numVertices(); i++) {
		    
			System.out.println("vertex: " + g.getVertices().get(i).data);
			
			//loop on the edges
			System.out.println("edge size: " + g.getVertices().get(i).countEdges());
			for(int j = 0; j<g.getVertices().get(i).countEdges(); j++) {
					System.out.println("edge: " + g.getVertices().get(i).getEdges().get(j).second.data);
				}
			}	
	}
	
	public static void bfs(Graph g) {
		
		//to keep track of all vertices
		Boolean visited[] = new Boolean[g.numVertices() + 1];
		System.out.println("numVerices : " + g.numVertices());
		for(int i=0;i<visited.length; i++) {
			visited[i] = false;
		}
		
		//printint graph
		//print(g);
		
		for(int i=0; i<g.numVertices(); i++) {
			if(visited[g.getVertices().get(i).data] == false) {
				System.out.println(g.getVertices().get(i).data);
				visited[g.getVertices().get(i).data] = true;
			}
			
			//loop on the edges
			for(int j = 0; j<g.getVertices().get(i).countEdges(); j++) {
				if(visited[g.getVertices().get(i).getEdges().get(j).second.data] == false) {
					System.out.println(g.getVertices().get(i).getEdges().get(j).second.data);
					visited[g.getVertices().get(i).getEdges().get(j).second.data] = true;
				}
			}
		}
		
	}
	public static void main(String[] args0) {
		
		Graph g = new Graph();
				
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 6);
		g.addEdge(1, 5);

		//now, bfs
		bfs(g);
		
		
		//graph print
		//g.print();
				
	}
}
