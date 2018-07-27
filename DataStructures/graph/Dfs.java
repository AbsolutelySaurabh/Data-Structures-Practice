package graph;

public class Dfs {
	
	public static void printdfs(Graph g, Vertex v, Boolean visited[]) {
		
		//print the first one
		if(visited[v.data] == false) {
			System.out.println(v.data);
			visited[v.data] = true;
		}else {
			return;
		}
		for(int i=0; i<v.countEdges(); i++) {
			printdfs(g, v.getEdges().get(i).second, visited);
		}
		
	}
	
	public static void dfs(Graph g) {
		
		//may check here if g.size() == 0 { return; }
		Boolean visited[] =  new Boolean[g.numVertices() + 1];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		printdfs(g, g.getVertices().get(0), visited);
		
		
	}

	public static void main(String[] args) {
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
		
		//print depth-first-search
		dfs(g);
	}

}
