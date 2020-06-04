package jianZhiOffer2;

import java.util.ArrayList;

public class Add {
    public int Add(int num1,int num2) {
    	while(num2 != 0){
    		int temp = (num1 & num2) << 1;
    		num1 = num1 ^ num2;
    		num2 = temp;
    	}
    	return num1;      
    }
    
    public static void main(String[] args){
    	Add test = new Add();
    	System.out.println(test.Add(19, 123));
    }
}
