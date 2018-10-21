package codezen;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Vertex{
    
    int data;
    Vector<Edge> edges = new Vector();
    
    public Vertex(int data){
        this.data = data;
    }
    
    public int numEdges(){
        return edges.size();
    }
    
    public void addEdge(Edge new_edge){ 
        edges.add(new_edge);
    }

}

class Edge{
    Vertex first;
    Vertex second;
    int edge_time;
    
    public Edge(Vertex v1, Vertex v2, int time){
        this.first = v1;
        this.second = v2;
        this.edge_time = time;
    }
}

class Graph{
    Vector<Vertex> vertices = new Vector();
    
    public Graph() {
    	
    }
    
    public void addVertex(int data){
        vertices.add(new Vertex(data));
    }
    
    public void addEdge(int first, int second, int time){
        
        //eg : addEdge(1, 2) -> then call vertices[1 - 1].addEdge(new Edge(1, 2))
        vertices.get(first-1).addEdge(new Edge(new Vertex(first), new Vertex(second), time));
        vertices.get(second-1).addEdge(new Edge(new Vertex(second), new Vertex(first), time));
    }
    
    public int numVertices(){
        return vertices.size();
    }
}


public class Solution {
    
    public static Scanner s = new Scanner(System.in);
    
    static void print_bfs(Graph g){
        
        for(int i=0; i<g.numVertices(); i++){
            System.out.println("vertex: " + g.vertices.get(i).data);
            
            for(int j=0; j<g.vertices.get(i).numEdges(); j++){
                System.out.println("edge: " + g.vertices.get(i).edges.get(j).second.data);
            }
        }
    }

    public static int min_time = Integer.MAX_VALUE;
    public static Boolean[][] visited;
    
    public static void solve_dfs(Graph g, Vertex v, int total_red_time, int reset_red_time, int curr_time, int des_vertex, int red_till_now){
        
        if(v.data == des_vertex){
            if(curr_time < min_time){
                min_time = curr_time;
            }
            System.out.println("found: ");
            return;
        }
        
        for(int i= 0; i<v.numEdges(); i++){
        	
        	if(visited[v.edges.get(i).first.data][v.edges.get(i).second.data] == false) {
            
	            curr_time = curr_time + v.edges.get(i).edge_time;
	            red_till_now += v.edges.get(i).edge_time;
	            reset_red_time-=red_till_now;
	            
	            visited[v.edges.get(i).second.data][v.edges.get(i).first.data] = true;
	            
	            if(reset_red_time <= 0){
	                reset_red_time = total_red_time;
	                curr_time += total_red_time;
	                red_till_now = 0;
	            }
	            
	            solve_dfs(g, v.edges.get(i).second, total_red_time, reset_red_time, curr_time, des_vertex, red_till_now);
	            
        	}     
        }
    }
    
    // Complete the leastTimeToInterview function below.
    public static void leastTimeToInterview(int n, int k, int m) {
        
        //add vertices from 1-n;
        Graph g = new Graph();
        for(int i=1; i<=n; i++){
            g.addVertex(i);
        }
        
        //vertices added, then input edges and time
        for(int i=0; i<m; i++){
            int first = s.nextInt();
            int second = s.nextInt();
            int edge_time = s.nextInt();
            
            g.addEdge(first, second, edge_time);
            
        }
        
        //start-solving
        int reset_red_time = k;
        
        //solve_dfs(g, g.vertices.get(0), k, reset_red_time, 0, n, 0);
        
        print_bfs(g);
        
    }

    public static void main(String[] args) throws IOException {

        int n = s.nextInt();

        int k = s.nextInt();

        int m = s.nextInt();
        
        visited = new Boolean[n+1][m+1];
        for(int i=0; i<=n; i++) {
        	for(int j=0; j<=n; j++) {
        		visited[i][j] = false;
        	}
        }

        leastTimeToInterview(n, k, m);
        System.out.println(min_time);

    }
}
