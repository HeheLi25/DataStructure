
public class Edge {
	int v1; 
	int v2; //边连接的两个顶点编号
	int weight;
	Edge next; //链表上的下一条边
	
	public Edge(int v1, int v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
		next = null;
	}
}
