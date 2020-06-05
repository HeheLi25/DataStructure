package jianZhiOffer2;

import java.util.ArrayList;

public class NextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
    	if (pNode == null) 
    		return null;
    	if(pNode.right != null)
    		return leftMost(pNode.right);
    	else 
    		return findParent(pNode);
    			
    }
    
    public TreeLinkNode leftMost(TreeLinkNode root){
    	if(root.left != null) 
    		return leftMost(root.left);
    	else
    		return root;
    }
    public TreeLinkNode findParent(TreeLinkNode child){
    	if(child.next == null) return null;
    	else if(child.next.left == child) return child.next;
    	else
    		return findParent(child.next);
    }
    //-----------------------------------------------------------------------
	ArrayList<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
    	if (pNode == null) return null;
    	TreeLinkNode root = pNode;
    	while(root.next != null){
    		root = root.next;
    	}
    	midTraverse(root);
    	int index = nodes.indexOf(pNode);
    	if (index >= nodes.size()-1) return null;
    	return nodes.get(index+1);
    	
    }
    public void midTraverse(TreeLinkNode node) {
    	if(node == null) return;
    	midTraverse(node.left);
    	nodes.add(node);
    	midTraverse(node.right);	
    }

    
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    
}
