package jianZhiOffer3;

public class Children {
    public int LastRemaining_Solution(int n, int m) {
    	if(n < 1) return -1;
    	Node cur = new Node(0);
    	Node pre = cur;
    	Node temp = null;
    	for(int i = 1; i < n; i++) {
    		temp = new Node(i);
    		pre.next = temp;
    		temp.pre = pre;
    		pre = temp;
    	}
    	pre.next = cur;
    	cur.pre = pre;
    	while(n > 1) {
    		for(int j = 1; j < m; j++) {
    			cur = cur.next;
    		}
    		cur.pre.next = cur.next;
    		cur.next.pre = cur.pre;
    		cur = cur.next;
    		n--;
    	}
    	return cur.val;
    }
    public static class Node {
    	int val;
    	Node next;
    	Node pre;
    	public Node(int v) {
    		val = v;
    	}
    }

}
