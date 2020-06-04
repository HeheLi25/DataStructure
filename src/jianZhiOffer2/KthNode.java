package jianZhiOffer2;

import java.util.Stack;

public class KthNode {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public TreeNode KthNode(TreeNode pRoot, int k){
    	//根节点放入递归方法
    	pushStack(pRoot);
    	TreeNode res = null;
    	//从栈中获取第k个
    	for(int i = 1; i <= k; i++){
    		if(stack.isEmpty()) return null;
    		res = stack.pop();
    	}
    	return res;
    }
    //递归将结点从大到小压栈
    public void pushStack(TreeNode root){
    	if(root == null) return;
    	//递归右子树
    	if(root.right != null){
    		pushStack(root.right);
    	} 		
    	//将自己压栈
    		stack.push(root);
    	//递归左子树
    	if(root.left != null)
    		pushStack(root.left);
    }
    
    public static void main(String[] args){
    	TreeNode t8 = new TreeNode(8);
    	TreeNode t6 = new TreeNode(6);
    	TreeNode t10 = new TreeNode(10);
    	TreeNode t5 = new TreeNode(5);
    	TreeNode t7 = new TreeNode(7);
    	TreeNode t9 = new TreeNode(9);
    	TreeNode t11 = new TreeNode(11);
    	t6.left = t5;
    	t6.right = t7;
    	t10.left = t9;
    	t10.right = t11;
    	t8.left = t6;
    	t8.right = t10;
    	KthNode test = new KthNode();
    	TreeNode res = test.KthNode(t8, 2);
    	System.out.println(res.val);
    	
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
