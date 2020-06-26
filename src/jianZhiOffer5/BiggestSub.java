package jianZhiOffer5;

public class BiggestSub {
    public int FindGreatestSumOfSubArray(int[] array) {
    	int res = array[0];
    	int max = res;
    	for(int i = 1; i < array.length; i++){
    		max = Math.max(max + array[i], array[i]);//包含array[i]的最大序列和
    		res = Math.max(res, max);
    	}
    	return res;
    }

}
