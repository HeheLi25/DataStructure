package jianZhiOffer3;

import jianZhiOffer3.TreeDepth.TreeNode;

public class IsBalanced {
	public int depth = -1;
	public boolean ans = true;
	
    public boolean IsBalanced_Solution1(TreeNode root) {
    	if(root == null) return true;
    	traverse(root, 0);
    	return ans;
    }
    public void traverse(TreeNode root, int d) {
    	if(root == null) {
    		if(depth == -1)
    			depth = d;
    		else {
    			if(Math.abs(d-depth) > 1)
    				ans = false;
    		}
    	}else {
    		traverse(root.left, d+1);
    		traverse(root.right, d+1);
    	}
    }
    
    

    	   public boolean IsBalanced_Solution(TreeNode root) {
    	        return getDepth(root) != -1;
    	    }
    	     
    	    private int getDepth(TreeNode root) {
    	        if (root == null) return 0;
    	        int left = getDepth(root.left);
    	        if (left == -1) return -1;
    	        int right = getDepth(root.right);
    	        if (right == -1) return -1;
    	        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    	    }
    
    
    public static void main(String[] args) {
    	IsBalanced test = new IsBalanced();
    	TreeNode t0 = new TreeNode(0);
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	TreeNode t5 = new TreeNode(5);
    	t0.left = t1;
    	t1.left = t3;
    	t1.right = t2;
    	t3.left = t4;
    	t4.left = t5;
    	System.out.println(test.IsBalanced_Solution(t0));
    }

    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
