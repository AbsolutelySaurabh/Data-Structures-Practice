package graph;

import java.util.Vector;

public class Graph {
	
	Vector<Vertex> vertices = new Vector<>();
	
	public int numVertices() {
		return vertices.size();
	}
	
	public void addVertex(int data) {
		
		Vertex v = new Vertex(data);
		vertices.add(v);
	}
	
	public int isVertexPresent(int d) {
		for(int i = 0; i< vertices.size(); i++) {
			if(vertices.get(i).data == d) {
				//System.out.println("vertex exists at index: " + i);
				return i;
			}
		}
		return -1;
	}
	
	public void addEdge(int data1, int data2) {
		
		//check if edge present
//		
//		int index1 = isVertexPresent(data1);
//		int index2 = isVertexPresent(data2);
//		
//		System.out.println("edge between : " + data1 + " " + data2);
//		System.out.println("indices : " + index1 + " " + index2);

		Vertex v1 = vertices.get(data1);
		Vertex v2 = vertices.get(data2);
		
		//check if edge already exists
		if(v1.isAdjacent(v2)) {
			return;
		}
		
		Edge newEdge_v1 = new Edge(v1, v2);
		v1.addEdge(newEdge_v1);
		Edge newEdge_v2 = new Edge(v2, v1);
		v2.addEdge(newEdge_v2);
		
	}
	
	public Vector<Vertex> getVertices(){
		return vertices;
	}
	
//	public void print() {
//		
//		System.out.println("vertices size: " + vertices.size());
//		for(int i=0;i<vertices.size();i++) {
//			vertices.get(i).print();
//		}
//	}

}
