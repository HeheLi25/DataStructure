package jianZhiOffer4;

public class KthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode n1 = head;
        ListNode n2 = head;
        int i = 0;
        for(; n1 != null; i++){
        	n1 = n1.next;
        	if(i >= k) n2 = n2.next;
        }
        if(i < k) return null;
        return n2;
    }
    
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
