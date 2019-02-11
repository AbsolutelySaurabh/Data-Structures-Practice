package UnDgraph;

import java.util.*;

class EdgeExistNt {
    
    static int nodes, edges;
    static LinkedList<Integer> ll[];
    
    public EdgeExistNt(int nodes, int edges){
        
        this.edges = edges;
        this.nodes = nodes;
        
        ll = new LinkedList[nodes+1];
        for(int i = 0; i<ll.length; i++){
            ll[i] = new LinkedList();
        }
    }
    
    public static void addEdge(int a, int b){
        ll[a].add(b);
        ll[b].add(a);
    }
    
    public static boolean edge_exist(int a, int b){
        
        for(int i = 0; i<ll[a].size(); i++){
            if(ll[a].get(i) == b){
                return true;
            }
        }
        return false;
    } 
    
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();
        
        EdgeExistNt t = new EdgeExistNt(nodes, edges);
        
        for(int  i = 0; i<edges; i++){
            
            int a = s.nextInt();
            int b = s.nextInt();
            
            t.addEdge(a, b);
        }
        
        int q = s.nextInt();
        for(int i = 0; i<q; i++){
            
            int a = s.nextInt();
            int b = s.nextInt();
        
            //graph made, perform operation
            if(edge_exist(a, b)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        
        }

    }
}
