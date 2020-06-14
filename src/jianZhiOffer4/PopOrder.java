package jianZhiOffer4;

import java.util.Stack;

public class PopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = pushA.length;
        if(len == 0) return true;
        int i = 0, j = 0;
        while(j < len && i < len) {
        	if(stack.isEmpty() || stack.peek() != popA[j]) {
        		stack.push(pushA[i++]);
        	}else{
        		stack.pop();
        		j++;
        	}
        }
        while(!stack.isEmpty()) {
        	if(j >= len || stack.pop() != popA[j++]) return false;
        }
        return true;
    }
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = pushA.length;
        if(len == 0) return true;
        int i = 0, j = 0;
        while(i < len) {
        	stack.push(pushA[i++]);
        	while(!stack.empty() && stack.peek() == popA[j]) {
        		stack.pop();
        		j++;
        	}
        }
        return stack.isEmpty();
    }
    
    
    
    public static void main(String[] args) {
    	PopOrder test = new PopOrder();
    	int[] t1 = {1,2,3,4,5};
    	int[] t2 = {4,5,3,2,1};
    	System.out.println(test.IsPopOrder(t1, t2));
    }
}
