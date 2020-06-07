package jianZhiOffer3;

public class TreeDepth {
	
    public int TreeDepth(TreeNode root) {
    	if(root == null) return 0;
        int ans = 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
        return ans;
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
