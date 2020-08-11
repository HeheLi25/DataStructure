package exam;

import java.util.HashMap;

class LRUCache {
    
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> map;
    int cap;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.pre = head;
        cap = capacity;
    }
    
    public int get(int key) {

        ListNode node = map.get(key);
        if(node == null) return -1;
        deleteNode(node);
        addHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        if(map.containsKey(key)){
            ListNode oldNode = map.get(key);
            map.put(key, newNode);
            deleteNode(oldNode);
        }else{
            map.put(key, newNode);
        }
        addHead(newNode);
        if(map.size() > cap){
            ListNode last = tail.pre;
            map.remove(last.k);
            removeTail();
        }
    }
    
    public void removeTail(){
        ListNode node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
    }
    public void addHead(ListNode node){
        ListNode temp = head.next;
        head.next = node;
        node.pre = head;
        temp.pre = node;
        node.next = temp;
    }
    public void deleteNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public class ListNode{
        public int value;
        public int k;
        public ListNode next;
        public ListNode pre;
        public ListNode(int key, int value){
            this.value = value;
            this.k = key;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
