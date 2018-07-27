package graph;

import java.util.Vector;
import graph.Edge;
public class Vertex {
	
	Integer data;
	Vector<Edge> edges = new Vector<>();
	
	public Vertex(Integer data) {
		this.data = data;
	}
	
	public int countEdges() {
		return edges.size(); 
	}
	
	public Vector<Edge> getEdges(){
		return edges;
	}
	
	public int numEdges(Vertex v) {
		return edges.size();
	}
	
	public boolean isAdjacent(Vertex v2) {
		for(int i=0;i<this.edges.size();i++) {
			if(edges.get(i).first == v2 || edges.get(i).second == v2 ) {
				return true;
			}
		}
		return false;
	}
	
	public void addEdge(Edge newEdge) {
		
		//System.out.println("Adding edge...");
		edges.add(newEdge);
		//System.out.println("Edge added: from " + newEdge.first.data + " -> " + newEdge.second.data);
	}
	
	public void removeEdge(Vertex v) {
		for(int i=0; i<edges.size(); i++) {
			if(edges.get(i).first == v || edges.get(i).second == v) {
				edges.remove(i);
				return;
			}
		}
	}
	
//	public void print() {
//		
//		System.out.println(this.data);
//		System.out.println("edges size: " + edges.size());
//		for(int i=0;i<edges.size();i++) {
//			if(edges.get(i).first.data == this.data) {
//				System.out.println(edges.get(i).second.data + " ");
//			}else {
//				System.out.println(edges.get(i).first.data + " ");
//			}
//		}
//		System.out.println();
//	}
	
//	Vector<Integer> getAllAdjacentVertices(){
//		
//		Vector<Integer> output;
//		for(int i=0; i<edges.size(); i++) {
//			if(edges.get(i).first == ths)
//		}
//	}

}
