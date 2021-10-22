package graphs;

import java.util.*;

public class GraphAdjacencyList {
	
	int V;
	ArrayList<Integer>[] LL;
	int visited[];
	Queue<Integer> Q = new PriorityQueue<Integer>();
	int topStart = -1;
	Stack<Integer> s ;
	
	GraphAdjacencyList(int vertices)
	{
		V = vertices;
		LL = new ArrayList[vertices];
		visited = new int[vertices];
		s = new Stack<Integer>();
	}
	
	void addEdge(int U, int V) {

		if(LL[U] == null) {
			LL[U] = new ArrayList<Integer>();
		}
		if(LL[V] == null) {
			LL[V] = new ArrayList<Integer>();
		}

		LL[U].add(V);
//		LL[V].add(U);
	}
	
	void printGraph() {
		for(int i = 0;i<V;i++) {
			ArrayList<Integer> L1 = LL[i];
				for(int j = 0;j<L1.size();j++) {
					System.out.println(L1.get(j)+" ");
				}
			System.out.println();	
		}
	}
	
	
	void DFS(int vertex) {
		if(visited[vertex] == 1) {
			return;
		}
		System.out.print(vertex+" ");
		visited[vertex] = 1;
		while(LL[vertex].size() > 0) {
//			System.out.println("the next vertex is "+LL[vertex].get(0));
			DFS(LL[vertex].get(0));
//			System.out.println("here");
			LL[vertex].remove(0);
		}
	}
	
	void BFS(int vertex) {
		for(int i = 0;i<visited.length;i++) {
			visited[i] = 0;
		}
		
		Q.add(vertex);
		
		
		while(!Q.isEmpty()) {
			vertex = Q.remove();
			if(visited[vertex]!=1) {
				System.out.println(vertex);
				for(int neighbour:LL[vertex]) {
					Q.add(neighbour);
				}
				visited[vertex] = 1;
			}
		}
		
	}
	
	Stack<Integer> TopologicalSort(int Vertex) {
	

		visited[Vertex] = 1;
		for(int neighbour: LL[Vertex]) {
			if(visited[neighbour] == 0) {
				visited[neighbour] = 1;
				TopologicalSort(neighbour);
			}
		}
		
		s.push(Vertex);
		return s;
		
	}
	
	void TopologicalSortUtil(int vertex){
		
		for(int i = 0;i<V;i++) {
			visited[i] = 0;
		}
		
		for(int i = 0;i<V;i++) {
			if(visited[i]==0) {
				System.out.println("calling for "+ i);
			s = TopologicalSort(i);
			}
		}
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
	}
	
	void unweightedShortestPath(int Vertex) {
		
		int[][] directed = new int[V][2];
		
		for(int i = 0;i<V;i++) {
			directed[i][0] = -1;
		}
		
		directed[Vertex][0] = 0;
		
		Q.clear();
		
		Q.add(Vertex);
		
		while(!Q.isEmpty()) {
			int ele = Q.remove();
			for(int neighbour:LL[ele]) {
				if(directed[neighbour][0] == -1) {
					Q.add(neighbour);
					directed[neighbour][0] = directed[ele][0]+1;
					directed[neighbour][1] = ele;
				}
			}
		}
		
		
		for(int i = 0;i<V;i++) {
			System.out.println("Distance between "+  Vertex +" to "+ i +" is "+ directed[i][0]);
		}
		
		
	}
	
	
	
}
