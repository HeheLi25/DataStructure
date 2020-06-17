package jianZhiOffer4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class OccurOnce {
	
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int k = 0; k < array.length; k++){
        	arr.add(array[k]);
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(; i < array.length; i++){
        	if(!set.add(array[i])){
        		arr.remove(new Integer(array[i]));
        		arr.remove(new Integer(array[i]));
        	}
        }
		if(arr.size() < 1) return;
        num1[0] = arr.get(0);
        if(arr.size() < 2) return;
        num2[0] = arr.get(1);
    }
    
    
    //This!
    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        num1[0] = 0;
        num2[0] = 0;
        int bitRes = 0;
        for(int i = 0; i < len; i++){
        	bitRes ^= array[i];
        }
        int pos = 0;
    	while((bitRes & 1) == 0 && pos < 32){
    		bitRes >>= 1;
    		pos++;
    	}
        for(int i = 0; i < len; i++){
        	if(((array[i] >> pos) & 1 )== 1)
        		num1[0] ^= array[i];
        	else
        		num2[0] ^= array[i];
        }
    }

    
    
    
    
    public static void main(String args[]){
    	int[] test = {1,2,3,6,7,6,1,5,3,7};
    	int[] t1 = new int[1];
    	int[] t2 = new int[1];
    	OccurOnce.FindNumsAppearOnce2(test, t1, t2);
    	System.out.println(t1[0]+" "+t2[0]);
//    	System.out.println(12^12);
    	
    }

}
