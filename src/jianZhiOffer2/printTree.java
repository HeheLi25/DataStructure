package jianZhiOffer2;

import java.util.ArrayList;

public class printTree {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        storeNode(pRoot, 0);
    	return res;
    	
    }
    public void storeNode(TreeNode root, int layer){
    	if(root == null) return;
    	while(res.size() <= layer)
    		res.add(new ArrayList<Integer>());
    	res.get(layer).add(root.val);
    	storeNode(root.left, layer+1);
    	storeNode(root.right, layer+1);	
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
