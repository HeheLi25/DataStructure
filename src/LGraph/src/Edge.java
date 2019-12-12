package LGraph.src;
public class Edge {
	int v1; 
	int v2; 
	int weight;
	Edge next; 
	
	public Edge(int v1, int v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
		next = null;
	}
}
