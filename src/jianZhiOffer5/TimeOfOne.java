package jianZhiOffer5;

public class TimeOfOne {
    public static int NumberOf1Between1AndN_Solution(int n) {
    	int counter = 0;
        for(int i = 1; i <= n; i++){
        	String s = i+"";
        	for(int j = 0; j < s.length(); j++){
        		if(s.charAt(j) == '1') counter ++;
        	}
        }
        return counter;
    }
    
    public int NumberOf1Between1AndN_Solution2(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;          
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
       }
        return count;
    }
    
    public static void main(String[] args){
    	int t = TimeOfOne.NumberOf1Between1AndN_Solution(55);
    	System.out.println(t);
    }

}
