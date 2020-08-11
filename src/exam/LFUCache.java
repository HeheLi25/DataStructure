package exam;

import java.util.HashMap;

class LFUCache {
    
    HashMap<Integer, Node> map1;
    HashMap<Integer, FreqList> map2;
    int cap;
    
    public LFUCache(int capacity) {
        map1 = new HashMap<Integer, Node>();
        map2 = new HashMap<Integer, FreqList>();
        map2.put(0, new FreqList());
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map1.get(key);
        if(node == null) return -1;
        int newFreq = node.freq + 1;
        if(!map2.containsKey(newFreq)){
            map2.put(newFreq, new FreqList());
        }
        FreqList old = map2.get(node.freq);
        old.delNode(node);
        node.freq = newFreq;
        FreqList newList = map2.get(newFreq);
        newList.add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        Node newNode = new Node(key, value, 0);
        if(map1.containsKey(key)){
            Node oldNode = map1.get(key);
            int oldFreq = oldNode.freq;
            FreqList oldList = map2.get(oldFreq);
            oldList.delNode(oldNode);
        }else{
            if(map1.size() == cap){
                int i = 0;
                while(!map2.get(i).delTail()) i++;
            }
        }
        FreqList firstList = map2.get(0);
        firstList.add(newNode);
        map1.put(key, newNode);

    }
    
    public class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node pre;
        public Node(int k, int v, int f){
            key = k;
            value = v;
            freq = f;
        }
    }
    public class FreqList{
        Node head;
        Node tail;
        public FreqList(){
            head = new Node(0,0,0);
            tail = new Node(0,0,0);
            head.next = tail;
            tail.pre = head;
        }
        public void add(Node node){
            Node temp = head.next;
            node.pre = head;
            head.next = node;
            node.next = temp;
            temp.pre = node;
        }
        public boolean delTail(){
            if(tail.pre == head) return false;
            Node del = tail.pre;
            del.pre.next = tail;
            tail.pre = del.pre;
            map1.remove(del.key);
            return true;
        }
        public void delNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    
    public static void main(String args[]) {
    	LFUCache cache = new LFUCache( 10 /* capacity */ );

    }
}