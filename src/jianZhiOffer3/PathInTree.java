package jianZhiOffer3;

import java.util.ArrayList;

public class PathInTree {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        path(root, target, new ArrayList<Integer>());
        return res;
    }
    public void path(TreeNode root, int target, ArrayList<Integer> arr) {
    	if(root == null) return;
    	target = target - root.val;
    	arr.add(root.val);
    	if(target == 0) {
    		if(root.left == null && root.right == null) {
    			res.add(arr);
    			return;
    		}else return;
    	}
    	if(target < 0) return;
    	
    	ArrayList<Integer> arr2 = (ArrayList<Integer>) arr.clone();
    	path(root.left, target, arr);
    	path(root.right, target, arr2);
    }
    
    
    
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

}
