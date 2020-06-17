package jianZhiOffer4;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(stack2.isEmpty() || node < stack2.peek())
        	stack2.push(node);
    }
    
    public void pop() {
        int i = stack.pop();
        if (stack2.peek() == i)
        	stack2.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return stack2.peek();
    }

}
