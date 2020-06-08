package jianZhiOffer2;

public class SymmTree {
	
    boolean isSymmetrical(TreeNode pRoot){
    	if(pRoot == null) return true;
        return isEqual(pRoot.left, pRoot.right);
    }
    boolean isEqual(TreeNode n1, TreeNode n2){
    	if(n1 == null || n2 == null){
    		if(n1 == n2) return true;
    		else return false;
    	}
    	if (n1.val == n2.val){
    		return isEqual(n1.left, n2.right) && isEqual(n2.left, n1.right);
    	}else{
    		return false;
    	}
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
