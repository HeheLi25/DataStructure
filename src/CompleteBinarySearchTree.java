import java.util.Scanner;

public class CompleteBinarySearchTree {
	public static int[] inputA;
	public static int[] resultT;
	public static void rearrange(int ALeft, int ARight, int TRoot) {
		int n = ARight - ALeft + 1;
		if(n <= 0) return;
		int L = getLeftLength(n); //n个结点的树左子树有多少个结点
		resultT[TRoot] = inputA[ALeft + L];	//根
		int LeftTRoot = TRoot * 2 + 1;  //左子树的根的位置
		int RightTRoot = LeftTRoot + 1;	//右子树的根的位置(层序遍历)
		rearrange(ALeft, ALeft+L-1, LeftTRoot);
		rearrange(ALeft+L+1, ARight, RightTRoot);
	}
	
	public static int getLeftLength(int n) {
		if(n == 1) return 0;
		int half = 1;
		int result = 0;//
		int remain = n-1; //去除根节点
		while((remain-2*half)>0) {
			result += half;
			remain = remain - 2*half;
			half *=2;
		}
		if(remain > half) {
			result = result + half;
		}else {
			result = result + remain;
		}
		return result;
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		inputA = new int[l];
		resultT = new int[l];
		for(int i = 0; i < l; i++) {
			inputA[i] = s.nextInt();
		}
		rearrange(0,l-1,0);
		for(int i: resultT) {
			System.out.print(i+" ");
		}
	}

}
