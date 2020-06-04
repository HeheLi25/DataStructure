package jianZhiOffer2;

import java.util.ArrayList;

public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	ArrayList<Integer> res = new ArrayList<Integer>();
        if(num.length < size || size == 0) return res;
        int lastMax = findMax(num, 0, size);
        res.add(lastMax);
        for(int j = 1; j < num.length-size+1; j++){
        	if(num[j-1] == lastMax){
        		lastMax = findMax(num, j, size);
        		res.add(lastMax);
        	}else if(num[j+size-1] > lastMax){
        		lastMax = num[j+size-1];
        		res.add(lastMax);
        	}else{
        		res.add(lastMax);
        	}
        }
        return res;
    }
    public int findMax(int[] num, int start, int size){
        int max = Integer.MIN_VALUE;
        for(int i = start; i < start + size; i++){
        	if(num[i] > max) max = num[i];
        }
        return max;
    }
    
    public static void main(String[] args){
    	SlideWindow test = new SlideWindow();
    	int[] a = {2,3,4,2,6,2,5,1};
    	ArrayList<Integer> b = test.maxInWindows(a, 3);
    	System.out.println(b.toString());
    }

}
