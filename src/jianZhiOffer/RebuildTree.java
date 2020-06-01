package jianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RebuildTree {
	
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        int position = -1;
        for(int i = 0; i < in.length; i++){
        	if(pre[0] == in[i]) position = i;
        }
        int[] inLeft =  Arrays.copyOfRange(in, 0, position);
        int[] inRight = Arrays.copyOfRange(in, position+1, in.length);
        int[] preLeft =  Arrays.copyOfRange(pre, 1, position+1);
        int[] preRight = Arrays.copyOfRange(pre, position+1, pre.length);
        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        
        return root;
        
    }

    
    public static void main(String[] args){
    	int[] pre = {1,2,4,7,3,5,6,8};
    	int[] in = {4,7,2,1,5,3,8,6};
    	TreeNode root = reConstructBinaryTree(pre, in);
    	
    	System.out.println(root.val);
    	System.out.println(root.left.val);
    	System.out.println(root.left.left.val);
    	System.out.println(root.left.left.right.val);
    	System.out.println(root.right.val);
    	System.out.println(root.right.left.val);
    	System.out.println(root.right.right.val);
    	System.out.println(root.right.right.left.val);
    }

    

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    
}
