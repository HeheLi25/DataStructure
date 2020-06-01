package jianZhiOffer;

import java.util.HashSet;
import java.util.Stack;

public class DupNode {
   public static ListNode deleteDuplication(ListNode pHead){
	   HashSet<Integer> nodes = new HashSet<Integer>();
	   HashSet<Integer> dup = new HashSet<Integer>();
	   ListNode cur = pHead;
	   while(cur != null){
		   if(!nodes.add(cur.val)){
			   dup.add(cur.val);
		   }
		   cur = cur.next;
	   }
	   ListNode head = pHead;
	   ListNode pre = null;
	   cur = pHead;
	   while(cur != null){
		   if(dup.contains(cur.val)){
			   if(pre == null){
				   head = head.next;
				   cur = head;
			   }else{
				   pre.next = cur.next;
				   cur = pre.next;
			   }
		   }else{
			   pre = cur;
			   cur = cur.next;
		   }
	   }
	   return head;
   }
   public static ListNode deleteDuplication2(ListNode pHead){
	   ListNode head = pHead;
	   ListNode cur = pHead;
	   ListNode dup;
	   ListNode pre = null;
	   ListNode temp;
	   while(cur!= null && cur.next != null){
		   if(cur.val == cur.next.val){
			   temp = cur.next;
			   while(temp != null && cur.val == temp.val){
				   temp = temp.next;
			   }
			   if(pre == null){
				   head = temp;
				   cur = temp;
			   }else{
				   pre.next = temp;
				   cur = temp;
			   }
		   }else{
			   pre = cur;
			   cur = cur.next;
		   }
	   }
	   return head;
   }
   
	public static ListNode ReverseList2(ListNode head) {
		if (head == null)
			return null;
		Stack<ListNode> nodes = new Stack<ListNode>();
		while (head != null) {
			nodes.push(head);
			head = head.next;
		}
		ListNode result = nodes.pop();
		ListNode nextNode = result;
		while (!nodes.isEmpty()) {
			nextNode.next = nodes.pop();
			nextNode = nextNode.next;
		}
		nextNode.next = null;
		return result;
	}
   
   
   public static void main(String[] args){
	   ListNode a = new ListNode(1);
	   ListNode b = new ListNode(2);
	   ListNode c = new ListNode(3);
	   ListNode d = new ListNode(3);
	   ListNode e = new ListNode(4);
	   ListNode f = new ListNode(5);
	   ListNode g = new ListNode(5);
	   a.next = b;
	   b.next = c;
	   c.next = d;
	   d.next = e;
	   e.next = f;
	   f.next = g;
	   ListNode r = ReverseList2(a);
	   while(r!=null){
		   System.out.print(r.val+"-->");
		   r = r.next;
	   }
	   
   }
   

	public static class ListNode {
	   int val;
	   ListNode next = null;
	
	   ListNode(int val) {
	       this.val = val;
	   }
	}

}
