package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraphs {
	
	class Node{
		int vertex;
		int weight;
		Node(int v,int w){
			vertex = v;
			weight = w;
		}
	}
	
	int vertices;
	ArrayList<Node> graph[];
	int distance[];
	int visited[];
	Queue<Integer> Q;
	LinkedList<Node> LL;
	
	WeightedGraphs(int vertices){
		this.vertices = vertices;
		this.graph = new ArrayList[vertices];
		this.distance = new int[vertices];
		this.visited = new int[vertices];
		this.Q = new PriorityQueue<Integer>();
		this.LL = new LinkedList<Node>();
		
		for(int i = 0;i<vertices;i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0;i<vertices;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
	}
	
	
	void addEdge(int source, int destination,int weight) {
		Node n = new Node(destination,weight);
		graph[source].add(n);
		graph[destination].add(new Node(source,weight));
	}
	
	
	
	int[] dijikistrasShortestPath(int vertex) {
		
		if(vertex == Integer.MAX_VALUE) {
			return distance;
		}
		
		if(distance[vertex] == Integer.MAX_VALUE) {
			distance[vertex] = 0;
		}
		
		int shortestDistance = Integer.MAX_VALUE;
		int shortestNode = Integer.MAX_VALUE;
		
		
		visited[vertex] = 1;
		
		for(Node n: graph[vertex]) {
			
				if(n.weight+distance[vertex] < 	distance[n.vertex])
				  distance[n.vertex] = n.weight+distance[vertex];
			
		}
		
		
		
		for(int i = 0;i<vertices;i++) {
			if(visited[i]!=1 && distance[i] < shortestDistance) {
				shortestDistance = distance[i];
				shortestNode = i;
			}
		}
		
		return dijikistrasShortestPath(shortestNode);
		
	}
	
	void djikistrasShortestPathUtil(int vertex) {
	
		int distance[] = dijikistrasShortestPath(vertex);
		
		for(int i = 0;i<vertices;i++) {
			System.out.println("Distance from vertex "+ vertex +" to "+ i + " is "+distance[i]);
		}
		
	}
	
	
	
	void belmannFordsAlgo(int vertex)
	{
		
		int orgVertex = vertex;
		for(int k = 0;k<vertices;k++) {
			distance[k] = Integer.MAX_VALUE;
		}
		
		distance[vertex] = 0;
		
		
		
		Q.add(vertex);
		
		
		for(int i = 1;i<vertices-1;i++) {
				for(int k = 0;k<vertices;k++) {
					visited[k] = 0;
				}
			
		while(!Q.isEmpty()) {	
				
			
			vertex = Q.remove();
			System.out.println(Q.isEmpty()+" "+vertex);
			if(visited[vertex] != 1)
			{
			visited[vertex] = 1;
			for(Node n: graph[vertex]) {
				
			
					Q.add(n.vertex);
//					visited[n.vertex] = 1;
					if(n.weight+distance[vertex] < distance[n.vertex]) {
						distance[n.vertex] = n.weight+distance[vertex];
					}
				}
			}
			}
			
		}
					
	
		
		for(int k = 0;k<vertices;k++) {
			System.out.println("distance from vertex "+orgVertex+" to "+k+" is "+distance[k]);
		}
		
		
	}	
	
	
	
	
	Node findShortestEdge(ArrayList<Node> MST){
		int i = 0;
		int shortestDistance = Integer.MAX_VALUE;
		Node shortestNode = null;
		Node removableNode = null;
		while(i < LL.size() && LL.get(i)!=null) {
			System.out.println(LL.get(i));
			for(Node n : graph[(LL.get(i)).vertex]) {
			  if(visited[n.vertex]!=1) {
				if(n.weight < shortestDistance) {
					shortestDistance = n.weight;
					shortestNode = n;
					removableNode = LL.get(i);
				}
			  }
			}
			 
			i++;
		
		MST.add(new Node(shortestNode.vertex,shortestDistance));
			
		}
//		System.out.println(shortestNode.vertex)s;
		LL.remove(removableNode);
		
		return shortestNode;
	}
	
	
	void primsAlgo() {
		ArrayList<Node> MST = new ArrayList<Node>();
		
		for(int i = 0;i<vertices;i++) {
			visited[i] = 0;
			distance[i] = Integer.MAX_VALUE;
		}
		
		LL.add(new Node(0,0));
		
		for(int i = 0;i<vertices-1;i++) {
		
				Node n = findShortestEdge(MST);
				
				System.out.println(n.vertex);
				
				visited[n.vertex] = 1;
				
				LL.add(n);
				

				
		}
		
		System.out.print(0+" ----> ");
		for(int i = 0;i<vertices-1;i++) {
			System.out.print(MST.get(i).vertex+" -----> "+ " ("+ MST.get(i).weight+" ) ");
		}
		
	}
	
   }
	

