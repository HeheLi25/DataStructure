
import java.util.Scanner;
public class TreeTraversalAgain {
	static int[] pre;
	static int[] in;
	static int[] post;
	
	public static void devide(int preL, int inL, int postL, int n) {
		if(n == 0) return;
		if(n == 1) {
			post[postL] = pre[preL];
			return;
		}
		int root = pre[preL];
		post[postL+n-1] = root;
		int i = 0;
		for(i = 0; i < n; i++) {
			if(in[inL+i] == root) break;
		}
		int L = i;
		int R = n-L-1;
		devide(preL+1, inL, postL, L);
		devide(preL+1+L, inL+L+1, postL+L, R);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		pre = new int[length];
		in = new int[length];
		post = new int[length];
		for(int i = 0; i < length; i++) {
			pre[i] = s.nextInt();
		}
		for(int i = 0; i < length; i++) {
			in[i] = s.nextInt();
		}
		devide(0,0,0,length);
		for(int i : post) {
			System.out.print(i + " ");
		}
		
		

	}

}
