package graph;
import java.util.*;

public class Graph {
	
	public int edges;
	public int vertices;
	private LinkedList<Integer> list[];
	
	public Graph(int edges){
		this.edges= edges;
		this.vertices = vertices;
		//taking vertices number as 100 initially
		list = new LinkedList[1001];
		for(int i = 0; i<100; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	private void addEdge(int a, int b){
		
		//taking undirectedGraoph first
		list[a].add(b);
		//list[b].add(a);
	}
	
	public void bfs(int start) {
		
		//for bfs need to do visited
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[100];
		for(int i = 0; i<visited.length ;i++) {
			visited[i] = false;
		}
		
		visited[start] = true;
		queue.add(start);
		while(queue.size()!=0) {
			
			int n = queue.poll();
			System.out.print(n + " ");
			Iterator<Integer> iterator = list[n].listIterator();
			while(iterator.hasNext()) {
				int num = iterator.next();
				if(!visited[num]) {
					visited[num] = true;
					queue.add(num);
				}
			}
		}
		
	}
	
	public void dfsUtil(int start, boolean visited[]) {
		
		visited[start] = true;
		System.out.print(start + " ");
		ListIterator<Integer> iter = list[start].listIterator();
		while(iter.hasNext()) {
			int n = iter.next();
			if(!visited[n]) {
				dfsUtil(n, visited);
			}
		}
	}
	
	public void dfs(int start) {
		
		boolean visited[] = new boolean[100];
		for(int i  = 0; i<100; i++) {
			visited[i] = false;
		}
		dfsUtil(start, visited);
	}
	
	public boolean isCyclicUtil(int start, boolean traceStack[], boolean visited[]) {
		
		System.out.print("start" + start +" ");
		if(traceStack[start]) {
			return true;
		}
		
		//need to add a visited here , as we;ve already checked the stack above
		//so, no need to go further is this parent-node is already visited
		if(visited[start]) {
			return false;
		}
		
		visited[start] = true;
		traceStack[start] = true;
		
		Iterator<Integer> iter = list[start].listIterator();
		while(iter.hasNext()) {
			
			int n = iter.next();
			if(isCyclicUtil(n, traceStack, visited)) {
				return true;
			}
			
		}
		traceStack[start] = false;
		return false;
	}
	
	public boolean isCyclic() {
		
		//do bfs and maintain traceStack
		boolean traceStack[] = new boolean[1001];
		boolean visited[] = new boolean[1001];
		
		for(int i = 0; i<visited.length; i++) {
			visited[i] = false;
			traceStack[i] = false;
		}
		/*
		 * The below case applies if we consider a start node,
		 * but, what for the case when we do not have a start node given
		 * return isCyclicUtil(0, traceStack, visited);
		 */
		 
		//the below case handles, when we do not have a start node given
		//Also, consider a scenario --> when start node is 0 when there is a self loop at 3, in this case start 
		// and end node for that vertex is 3 only
		//THEREFORE ::  we make start vertex to every vertex and check popssibility of cyclic for each vertex
		for(int i = 0; i < vertices; i++) {
			if(isCyclicUtil(i, traceStack, visited)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//number of edges/ vertices
		int n = s.nextInt();
		Graph g = new Graph(n);
		while(n > 0) {
			
			int a = s.nextInt();
			int b = s.nextInt();
			g.addEdge(a, b);
			n--;
		}
		
		//find DFS
		g.bfs(1);
		System.out.println();
		g.dfs(1);
		if(g.isCyclic()) {
			System.out.println("is cyclic");
		}else {
			System.out.println("not cyclic");
		}
		s.close();
	}

}
