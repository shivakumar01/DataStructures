package graphs;

import java.util.Stack;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GraphAdjacencyList G = new GraphAdjacencyList(8);
//		G.addEdge(0, 1);
//		G.addEdge(0, 3);
//		G.addEdge(0, 2);
//		G.addEdge(1, 4);
//		G.addEdge(1, 3);
//		G.addEdge(3, 5);
//		G.addEdge(3, 6);
//		G.addEdge(2, 5);
//		G.addEdge(4, 6);
//		G.addEdge(6, 5);
//		G.addEdge(6, 7);
//		
////		G.DFS(0);
//		System.out.println();
//	 	G.unweightedShortestPath(0);
		
		WeightedGraphs graph = new WeightedGraphs(5);
		
		graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 10);
        graph.addEdge(3, 1, 4);
        graph.addEdge(2, 4, 6);
        graph.addEdge(4, 3, 1);
        graph.addEdge(3, 2, 2);
//        graph.addEdge(4, 3, -3);
//        graph.addEdge(3, 2, 5);
//        graph.addEdge(4, 1, 1);

		
		graph.djikistrasShortestPathUtil(0);
		graph.belmannFordsAlgo(0);
		graph.primsAlgo();
	}

}
