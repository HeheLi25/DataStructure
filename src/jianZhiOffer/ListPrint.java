package jianZhiOffer;





import java.util.ArrayList;
public class ListPrint {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        while(listNode != null){
        	result1.add(listNode.val);
        	listNode = listNode.next;
        }
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        for(int i = result1.size()-1; i>=0; i--){
        	result2.add(result1.get(i));
        }
        return result2;    
    }
    

    
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        recursion(listNode,result);
        return result;
    }
    
    public void recursion(ListNode listNode,ArrayList<Integer> result){
    	if(listNode == null) return;
    	else{
    		recursion(listNode.next,result);
    		result.add(listNode.val);
    		return;
    	}
    }
    
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode temp = null;
        while(cur != null){
        	temp = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = temp; 	
        }
        while(pre != null){
        	result.add(pre.val);
        	pre = pre.next;
        }
        return result;
    }
    
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
