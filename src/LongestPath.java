
public class LongestPath {
	public static int max = -1;
	
	public static int longestPathBetweenLeaves(Node n) {
		if(n == null) return 0;
		findDepth(n);
		return max;
	}
	public static int findDepth(Node n) {
		if(n == null) return -1;
		int leftDepth = findDepth(n.left)+1;
		int rightDepth = findDepth(n.right)+1;
		int sum = leftDepth + rightDepth;
		if(sum > max) max = sum;
		return Math.max(leftDepth, rightDepth);
	}
	
	public static void main(String[] args) {
		Node root = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		Node n9 = new Node();
		root.left = n1;
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n2.right = n5;
		n1.right = n6;
		n6.right = n7;
		n7.right = n8;
		root.right = n9;
		System.out.println(longestPathBetweenLeaves(root));
	}
	
	
	
	
	
}

class Node {
	public Node left;
	public Node right;
}
