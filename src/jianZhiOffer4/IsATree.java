package jianZhiOffer4;

public class IsATree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len < 1) return false;
        return tool(sequence, 0, sequence.length-1);
    }
    public boolean tool(int[] seq, int left, int right) {
    	if(left >= right) return true;
    	int root = seq[right];
    	int i = right-1;
    	while(i >= left && seq[i] > root) i--;
    	for(int j = i; j >= left; j--) {
    		if(seq[j] >= root) return false;
    	}
    	return tool(seq, left, i) && tool(seq, i+1, right-1);
    }
    
    public static void main(String[] args) {
    	IsATree test = new IsATree();
    	int[] t = {5,4,3,2,1};
    	System.out.println(test.VerifySquenceOfBST(t));
    }

}
