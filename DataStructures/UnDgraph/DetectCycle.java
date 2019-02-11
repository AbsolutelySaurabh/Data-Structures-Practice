package UnDgraph;
import java.util.*;
public class DetectCycle {
	
	public static int edges, vertices;
	public static LinkedList<Integer> ll[];
	public static int visited[];
	public static int countCycles = 0;
	
	public DetectCycle(int edges){
		this.vertices = edges + 1; //max number of v = edges + 1, if not isolated component
		
		ll = new LinkedList[vertices + 1];
		for(int i = 0; i<ll.length; i++){
			ll[i] = new LinkedList();
		}
		
		visited = new int[ll.length];
		for(int i = 0; i<visited.length; i++){
			visited[i] = 0;
		}
	}
	
	public static void addEdge(int a, int b){
		ll[a].add(b);
		ll[b].add(a);
	}
	
	public static boolean dfs(int v, int head){
		
		visited[v] = 1;
		for(int i = 0; i<ll[v].size(); i++){	
			
			int num = ll[v].get(i);
			if(visited[num] == 0){
				return dfs(num, v);
			}
			if(num!=head){
				return true;
			}
		}
		return false;
	}
	
	public static boolean dfsUtil(){
		
		for(int i = 1; i<=vertices; i++){
			
			if(visited[i] == 0){
				if(dfs(i, -1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int edges = s.nextInt();
		DetectCycle g = new DetectCycle(edges);
		for(int i = 0; i<edges; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			
			addEdge(a, b);
		}
		if(dfsUtil()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		System.out.println("Countcycles : " + countCycles);
	}

}
