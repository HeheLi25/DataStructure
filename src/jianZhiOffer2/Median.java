package jianZhiOffer2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	int counter = 0;
    public void Insert(Integer num) {

    	if(counter % 2 == 0){
    		maxHeap.add(num);
    		minHeap.add(maxHeap.poll());
    	}else{
    		minHeap.add(num);
    		maxHeap.add(minHeap.poll());
    	}
    	counter++;
    }

    public Double GetMedian() {
    	if(counter == 0) return null;
    	if(counter % 2 == 0){
    		return (minHeap.peek() + maxHeap.peek()) / 2.0;
    	}else{
    		return minHeap.peek() * 1.0;
    	}
    }
    
    public static void main(String[] args){
    	Median test = new Median();
    	System.out.println(test.GetMedian());
    	test.Insert(5);
    	System.out.println(test.GetMedian());
    	test.Insert(2);
    	System.out.println(test.GetMedian());
    	test.Insert(3);
    	System.out.println(test.GetMedian());
    	test.Insert(4);
    	System.out.println(test.GetMedian());
    }


}
