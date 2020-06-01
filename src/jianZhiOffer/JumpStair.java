package jianZhiOffer;

public class JumpStair {
    public int JumpFloor(int target) {
    	int first = 0;
    	int second = 1;
    	int result = 0;
    	for(int i = 1; i <=target; i++){
    		result = first + second;
    		first = second;
    		second = result;
    	}
    	return result;
    }

}
