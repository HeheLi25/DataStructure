package jianZhiOffer4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevel {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        while(!q.isEmpty()) {
        	TreeNode cur = q.poll();
        	ans.add(cur.val);
        	if(cur.left != null) q.offer(cur.left);
        	if(cur.right != null) q.offer(cur.right);
        }
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
