package jianZhiOffer3;

public class TreeToLink {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.right == null && pRootOfTree.left == null)
        	return pRootOfTree;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while(p!=null&&p.right!=null){
        	p = p.right;
        }
        if(left != null) {
        	p.right = pRootOfTree;
        	pRootOfTree.left = p;
        }
        TreeNode right = Convert(pRootOfTree.right);
        TreeNode q = right;
        while(q!=null&&q.left!=null){
        	q = q.left;
        }
        if(right != null) {
        	q.left = pRootOfTree;
        	pRootOfTree.right = q;
        }
        return left != null ? left : pRootOfTree;
        
    	
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
