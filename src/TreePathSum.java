
public class TreePathSum {
	
	
    public static boolean findPath(TreeNode root, int sum){
        if(root == null)
            return false;
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        boolean result = findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);
        return result;
    }
    

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

