package jianZhiOffer;

public class CutRope {
    public static int cutRope(int target) {
    	if(target == 2) return 1;
    	if(target == 3) return 2;
    	int[] a = new int[target+1];
    	for(int i = 0; i<=4; i++){
    		 a[i] = i;
    	}
    	for(int i = 5; i<=target; i++){
    		for(int j = 1; j<i; j++){
    			a[i] = Math.max(a[i], a[i-j]*j);
    		}
    	}
    	return a[target];
    }
    public static int cutRope2(int target) {
    	if(target == 2) return 1;
    	if(target == 3) return 2;
    	else{
    		return back_track(target);
    	}
    }
    public static int back_track(int n) {
    			if (n <= 4) {
    	            return n;
    	        }
    	        int ret = 0;
    	        for (int i = 1; i < n; ++i) {
    	            ret = Math.max(ret, i * back_track(n - i));
    	        }
    	        return ret;
    	    }
    

    public static void main(String[] arg){
    	System.out.println(cutRope2(8));
    }
}

