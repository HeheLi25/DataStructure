import java.util.LinkedList;

public class LGraph {
	int numV;	//顶点的数量
	int numE;	//边的数量
	Head[] graph;	//存储图的数组，数组里的元素是每条链表的头结点
	boolean[] visited;
	
	/* Constructor */
	public LGraph(int numV){
		this.numV = numV;
		numE = 0;
		graph = new Head[numV];
		visited = new boolean[numV];
		for(int v = 0; v < numV; v++){
			graph[v] = new Head();	//初始化顶点
			visited[v] = false;		//每个顶点都初始化为未访问
		}
	}
	/* 插入一条边 */
	public void insertEdge(Edge edge){
		if(graph[edge.v1].next != null)
			edge.next = graph[edge.v1].next;
		graph[edge.v1].next = edge;	//将新边插在v1顶点的头结点后
		/* 如果是无向图，反向也要插入*/
		Edge edge2 = new Edge(edge.v2, edge.v1, edge.weight);	//创建一个和新边一样的边实例，插在v2的头结点后
		edge2.next = graph[edge2.v1].next;
		graph[edge2.v1].next = edge2;
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
}
