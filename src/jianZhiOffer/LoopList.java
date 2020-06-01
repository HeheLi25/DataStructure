package jianZhiOffer;

import java.util.HashSet;
public class LoopList {

   public ListNode EntryNodeOfLoop(ListNode pHead){
	   HashSet<ListNode> nodes = new HashSet<ListNode>();
	   ListNode cur = pHead;
	   while(cur != null){
		   if(!nodes.add(cur)){
			   return cur;
		   }
		   cur = cur.next;
	   }
       return null;
   }
   
   public ListNode EntryNodeOfLoop2(ListNode pHead){
	   ListNode spec = new ListNode(0);
	   ListNode fast = pHead.next;
	   ListNode slow = pHead;
	   while(fast != null){
		   slow.next = spec;
		   slow = fast;
		   fast = fast.next;
		   if(fast.equals(spec)) return fast;
	   }
	   return null;
   }
   
   
   
   
   public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
          this.val = val;
      }
   }

}
