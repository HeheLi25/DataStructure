package jianZhiOffer4;

import java.util.Arrays;

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

        public boolean VerifySquenceOfBST2(int [] sequence) {
            if(sequence.length <= 1) return true; 
            int len = sequence.length;
            int root = sequence[len-1];
            int mid = 0;
            for(int i = 0; i < len; i++){
                if(sequence[i] >= root) {
                    mid = i;
                    break;
                }
            }
            for(int i = mid; i < len-1; i++){
                if(sequence[i] < root) {
                	
                    return false;
                }
            }
            int[] left = Arrays.copyOfRange(sequence, 0, mid);
            int[] right = Arrays.copyOfRange(sequence, mid, len-1);
            return VerifySquenceOfBST2(left) && VerifySquenceOfBST2(right);
        }

    
    public static void main(String[] args) {
    	IsATree test = new IsATree();
    	int[] t = {4,6,7,5};
    	System.out.println(test.VerifySquenceOfBST2(t));
    }

}
