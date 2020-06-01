package jianZhiOffer;

import java.util.ArrayList;

public class Fibo {
	
    public int Fibonacci(int n) {
    	ArrayList<Integer> fibo = new ArrayList<Integer>();
    	if(n == 0) return 0;
    	if(n == 1) return 1;
    	fibo.add(0);
    	fibo.add(1);
    	for(int i = 2; i <= n; i++)
    		fibo.add(fibo.get(i-1)+fibo.get(i-2));
    	return fibo.get(fibo.size()-1);
    }
    
    public static int Fibonacci2(int n) {
    	int first = 0;
    	int second = 1;
    	int result = 0;
    	if(n == 1) return 1;
    	for(int i = 2; i <=n; i++){
    		result = first + second;
    		first = second;
    		second = result;
    	}
    	return result;
    }
    
    public static void main (String[] args){
    	System.out.println(Fibonacci2(2));
    }

}
