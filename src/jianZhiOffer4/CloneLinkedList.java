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
    public static void main(String[] args){
    	RandomListNode t1 = new RandomListNode(1);
    	RandomListNode res = Clone(t1);
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
