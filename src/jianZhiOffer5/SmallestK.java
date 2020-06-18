package jianZhiOffer5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(input.length < k || k == 0) return ans;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return o2-o1;
    		}});
        int i = 0;
        while(heap.size() < k){
    		heap.offer(input[i++]);
        }
        for(; i < input.length; i++){
        	if(input[i] < heap.peek()){
        		heap.poll();
        		heap.offer(input[i]);
        	}
        }
        for(int j = 0; j < k; j++){
        	ans.add(heap.poll());
        }
        return ans;
    }

}
