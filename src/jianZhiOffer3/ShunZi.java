package jianZhiOffer3;

public class ShunZi {
    public boolean isContinuous(int [] numbers) {
    	if(numbers.length != 5) return false;
    	int min = 15;
    	int max = -1;
    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i] == 0) continue;
    		if(numbers[i] > max) max = numbers[i];
    		if(numbers[i] < min) min = numbers[i];
    		for(int j = i+1; j < numbers.length; j++) {
    			if(numbers[i] == numbers[j]) return false;
    		}
    	}
    	int gap = max - min;
    	if(gap <= 4) return true;
    	else return false;

    }
    
    public static void main(String args[]) {
    	ShunZi test = new ShunZi();
    	int[] t = {0,0,0,0,0};
    	System.out.println(test.isContinuous(t));
    }

}
