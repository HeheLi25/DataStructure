package jianZhiOffer4;

import java.util.Stack;

public class ReverseLinkList {
    public ListNode ReverseList(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = head;
    	ListNode next = null;
    	while(cur != null){
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	return pre;
    }
    public static ListNode ReverseList2(ListNode head) {
        ListNode node = head;
		Stack<ListNode> stack = new Stack<ListNode>();
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        if(stack.isEmpty()) return head;
        head = stack.pop();
        node = head;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return head;
    }
    public static void main(String[] args) {
    	ListNode t1 = new ListNode(1, null);
    	ListNode t2 = new ListNode(2, t1);
    	ListNode t3 = new ListNode(3, t2);
    	ListNode t4 = new ListNode(4,t3);
    	ListNode newHead = ReverseList2(t4);
    	while(newHead != null) {
    		System.out.println(newHead.val);
    		newHead = newHead.next;
    	}
    	
    }
    
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val, ListNode n) {
            this.val = val;
            next = n;
        }
    }

}
