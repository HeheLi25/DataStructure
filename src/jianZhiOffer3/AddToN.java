package jianZhiOffer3;

public class AddToN {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean b = (n > 0) && ((ans += Sum_Solution(n - 1))>0);
        return ans;
    }
	

}
