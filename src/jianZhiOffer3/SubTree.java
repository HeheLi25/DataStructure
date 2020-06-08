package jianZhiOffer3;

import jianZhiOffer3.IsBalanced.TreeNode;

public class SubTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) 
        	return false;
        if(root1.val == root2.val) {
        	if(judgeTree(root1, root2)) 
        		return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    public boolean judgeTree(TreeNode a, TreeNode b) {
    	if(b == null) return true;
    	if(a == null) return false;
   		if(a.val == b.val) 
    		return judgeTree(a.left, b.left) && judgeTree(a.right, b.right);
    	else return false;
    }
    

    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    
    public static void main(String args[]) {
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
    	SubTree test = new SubTree();
    	System.out.println(test.HasSubtree(t0, t3));
    }

}
