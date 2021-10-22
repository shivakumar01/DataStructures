package graphs;

public class Graph {
	
	int adj[][];
	int V;
	int E;
	
	Graph(int V, int E){
		adj = new int[V][V];
		this.V = V;
		this.E = E;
	}
	
	void addEdge(int vert1,int vert2) {
		
		if(vert1 <= 0 || vert1 >= V || vert2 <= 0 || vert2 >= V) {
			return;
		}
		
		adj[vert1][vert2] = 1;
		adj[vert2][vert1] = 1;
	}
	
	void deleteEdge(int vert1,int vert2) {
		
		if(vert1 <= 0 || vert1 >= V || vert2 <= 0 || vert2 >= V) {
			return;
		}
		
		adj[vert1][vert2] = 0;
		adj[vert2][vert1] = 0;
	}
	
	void printGraph() {
	
		for(int i = 0;i < (V);i++) {
			for(int j = 0;j<V;j++) {
				System.out.println(adj[i][j]+" ");
			}
		System.out.println();
		}
		
	}
	
	
	

}
