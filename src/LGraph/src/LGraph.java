package LGraph.src;
import java.util.LinkedList;

public class LGraph {
	int numV;	
	int numE;	
	Head[] graph;	
	boolean[] visited;
	
	int dist[];
	int path[];
	
	/* Constructor */
	public LGraph(int numV){
		this.numV = numV;
		numE = 0;
		graph = new Head[numV];
		visited = new boolean[numV];
		path = new int[numV];
		dist = new int[numV];
		for(int v = 0; v < numV; v++){
			graph[v] = new Head();	
			visited[v] = false;
			path[v] = -1;
			dist[v] = -1;
		}
	}

	public void insertEdge(Edge edge){
		if(graph[edge.v1].next != null)
			edge.next = graph[edge.v1].next;
		graph[edge.v1].next = edge;	
		/* If edges do not have direction */
//		Edge edge2 = new Edge(edge.v2, edge.v1, edge.weight);
//		edge2.next = graph[edge2.v1].next;
//		graph[edge2.v1].next = edge2;
		numE++;
	}
	
	public void DFS(int v){
		visited[v] = true;
		System.out.print(v);
		for(Edge e = graph[v].next; e!=null; e = e.next){
			if(!visited[e.v2]){
				DFS(e.v2);
			}
		}
	}
	
	public void BFS(int v){
		LinkedList<Integer> queue = new LinkedList();
		visited[v] = true;
		System.out.print(v);
		queue.add(v);
		while(!queue.isEmpty()){
			v = queue.removeFirst();
			for(Edge e = graph[v].next; e!=null; e = e.next){
				if(!visited[e.v2]){
					visited[e.v2] = true;
					System.out.print(e.v2);
					queue.add(e.v2);
				}
			}
		}
	}
	
	public void DFSTraverse(){
		for(int v = 0; v < numV; v++){
			if(!visited[v]){
				DFS(v);
			}
		}
		System.out.println();
		initVisited();
	}
	public void BFSTraverse(){
		for(int v = 0; v < numV; v++){
			if(!visited[v]){
				BFS(v);
			}
		}
		System.out.println();
		initVisited();
	}
	public void initVisited(){
		for(int v = 0; v < numV; v++){
			visited[v] = false;		
		}
	}
	
	
	public void printG(){
		for(int i = 0; i < graph.length; i++){
			System.out.print("g["+i+"]->");
			Edge temp = graph[i].next;
			while(temp!=null){
				System.out.print(temp.v2+"->");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	public void initPathAndDist() {
		for(int i = 0; i < numV; i++) {
			dist[i] = -1;
			dist[i] = -1;
		}
	}
	
	public void unweightedShortestPath(int v) {
		initPathAndDist();
		dist[v] = 0;
		LinkedList<Integer> queue = new LinkedList();
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.removeFirst();
			for (Edge e = graph[v].next; e != null; e = e.next) {
				if (dist[e.v2] == -1) {
					dist[e.v2] = dist[e.v1]+1;
					path[e.v2] = e.v1;
					queue.add(e.v2);
				}
			}
		}
	}
}
