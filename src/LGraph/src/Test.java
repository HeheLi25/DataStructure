import java.util.Scanner;
public class Test {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int numV = s.nextInt();
		int numE = s.nextInt();
		LGraph g = new LGraph(numV);
		for(int i = 0; i < numE; i++){	//通过输入创建各边，插入图中
			Edge e = new Edge(s.nextInt(),s.nextInt(),s.nextInt());
			g.insertEdge(e);
		}
		g.printG();
		
		g.DFSTraverse();
		g.BFSTraverse();
		
		
		
	}

}

/*
 * 输入：
 * 5 4
 * 0 3 2
 * 1 0 3
 * 2 4 4 
 * 0 4 5
 */