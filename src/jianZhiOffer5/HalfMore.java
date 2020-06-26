package jianZhiOffer5;

import java.util.Arrays;

public class HalfMore {
    public int MoreThanHalfNum_Solution(int [] array) {
    	Arrays.sort(array);
        int len = array.length - 1;
        int ele = array[(len/2)];
        int counter = 0;
        for(int i = 0; i <= len; i++){
        	if(array[i] == ele)
        		counter++;
        	if(counter * 2 > len+1)
        		return ele;
        }
        return 0;
    }
}
