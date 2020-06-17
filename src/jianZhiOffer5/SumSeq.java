package jianZhiOffer5;

import java.util.ArrayList;

public class SumSeq {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 1; i <= sum/2; i++) {
        	int res = 0;
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for(int j = i; res < sum; j++) {
        		res = res + j;
        		list.add(j);
        	}
        	if(res == sum) ans.add(list);
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int i1 = 1, i2 = 2;
        while(i1 < i2 && i2 <= sum/2+1) {
        	int res = (i1+i2)*(i2-i1+1)/2;
        	if(res > sum) {
        		i1++;
        	}else if(res < sum) {
        		i2++;
        	}else {
        		ArrayList<Integer> a = new ArrayList<Integer>();
        		for(int i = i1; i <= i2; i++) {
        			a.add(i);
        		}
        		ans.add(a);
        		i1++;
        	}
        }
        return ans;
    }

    	    public ArrayList<ArrayList<Integer> > FindContinuousSequence3(int sum) {
    	        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    	        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
    	            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
    	                ArrayList<Integer> list = new ArrayList<>();
    	                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
    	                    list.add(k);
    	                }
    	                ans.add(list);
    	            }
    	        }
    	        return ans;
    	    }

}
