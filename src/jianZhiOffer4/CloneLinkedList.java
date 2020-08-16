package jianZhiOffer4;



public class CloneLinkedList {
    public static RandomListNode Clone(RandomListNode pHead) {
    	if(pHead == null) return null; 
    	//clone nodes in the old list.
    	RandomListNode cur = pHead;
    	RandomListNode temp = null;
    	while(cur != null){
    		RandomListNode newNode = new RandomListNode(cur.label+100);
    		temp = cur.next;
    		cur.next = newNode;
    		newNode.next = temp;
    		cur = temp;
    	}
    	//Set the random pointer
    	cur = pHead;
    	while(cur!= null){
    		temp = cur.random;
    		if (temp == null) {
    			cur = cur.next.next;
    			continue;
    		}
    		cur.next.random = temp.next;
    		cur = cur.next.next;
    	}
    	//Split
    	RandomListNode newHead = pHead.next;
    	RandomListNode newCur;
    	cur = pHead;
    	while (cur != null){
    		newCur = cur.next;
    		cur.next = newCur.next;
    		if(newCur.next != null)newCur.next = newCur.next.next;
    		cur = cur.next;
    	}
    	return newHead;
    }
    
    
    public static RandomListNode Clone2(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode copy;
        RandomListNode temp;
        while(node != null){
            copy = new RandomListNode(node.label);
            temp = node.next;
            copy.next = temp;
            node.next = copy;
            node = temp;
        }
        node = pHead;
        while(node != null){
            temp = node.random;
            if(temp != null)
            	node.next.random = temp.next;
            else node.next.random = null;
            node = node.next.next;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        node = pHead;
        while(node != null){
            temp = node.next;
            pre.next = temp;
            node.next = temp.next;
            node = node.next;
            pre = pre.next;
        }
        return dummy.next;
    }
    
    
    public static void main(String[] args){
    	RandomListNode t1 = new RandomListNode(1);
    	RandomListNode t2 = new RandomListNode(2);
    	RandomListNode t3 = new RandomListNode(3);
    	RandomListNode t4 = new RandomListNode(4);
    	t1.next = t2;
    	t2.next = t3;
    	t3.next = t4;
    	t1.random = t3;
    	t2.random = t4;
    	t3.random = null;
    	t4.random = t1;
    	RandomListNode res = Clone2(t1);
    	System.out.println(res.label+","+res.next.label+","+res.next.next.label+","+res.next.next.next.label);
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
