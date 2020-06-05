package jianZhiOffer2;

public class SerializeTree {
	int i = -1;
    String Serialize(TreeNode root) {
        String res = "";
        if (root == null){
        	return "#!";
        }
        res = res + root.val + "!";
        res = res + Serialize(root.left);
        res = res + Serialize(root.right);
        return res;
    }
    
    TreeNode Deserialize(String str) {
    	String[] s = str.split("!");
    	i++;
       	if(s[i].equals("#") || i >= s.length){
       		return null;
       	}
   		TreeNode node = new TreeNode(Integer.parseInt(s[i]));
   		node.left = Deserialize(str);
   		node.right = Deserialize(str);
   		return node;
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
