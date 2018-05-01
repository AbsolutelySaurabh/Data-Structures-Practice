package graph;

import java.util.Vector;

public class Graph {
	
	Vector<Vertex> vertices = new Vector<>();
	
	public int numVertices() {
		return vertices.size();
	}
	
	public int numEdges() {
		int num = 0;
		for(int i=0; i<vertices.size();i++) {
			num += vertices.get(i).countEdges();
		}
		return num/2;
	}
	
	public void addVertex(int data) {
		
		Vertex v = new Vertex(data);
		vertices.add(v);
	}
	
	public int isVertexPresent(int d) {
		for(int i = 0; i< vertices.size(); i++) {
			if(vertices.get(i).data == d) {
				System.out.println("vertex exists at index: " + i);
				return i;
			}
		}
		return -1;
	}
	
	public void addEdge(int data1, int data2) {
		
		//check if any of em exists or not
		if( (isVertexPresent(data1) == -1) || (isVertexPresent(data2) == -1)) {
			return;
		}
		
		int index1 = isVertexPresent(data1);
		int index2 = isVertexPresent(data2);
		Vertex v1 = vertices.get(index1);
		Vertex v2 = vertices.get(index2);
		
		//check if edge already exists
		if(v1.isAdjacent(v2)) {
			return;
		}
		
		Edge newEdge = new Edge(v1, v2);
		v1.addEdge(newEdge);
		v2.addEdge(newEdge);
		
	}
	
	public void print() {
		
		System.out.println("vertices size: " + vertices.size());
		for(int i=0;i<vertices.size();i++) {
			vertices.get(i).print();
		}
	}

}
