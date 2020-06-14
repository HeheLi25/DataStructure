package jianZhiOffer4;

import java.util.ArrayList;

public class printMatrix {
	ArrayList<Integer> res = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int heightEnd = matrix.length-1;
        int widthEnd = matrix[0].length-1;
        int widthStart = 0;
        int heightStart = 0;
        while(widthEnd >= widthStart && heightEnd >= heightStart) {
        	tool(matrix, widthEnd--, heightEnd--, widthStart++, heightStart++);
        }
        return res;
    }
    
    public void tool(int[][] m, int we, int he, int ws, int hs) {
    	if(we == ws) { //一竖排
    		while(hs <= he) {
    			res.add(m[hs++][we]);
    		}
    	}
    	else if(he == hs) { //一横排
    		while(ws <= we) {
    			System.out.println(ws);
    			res.add(m[he][ws++]);
    		}
    	}else {
    		
    		int tempW = ws;
    		int tempH = hs;
    		while(tempW < we) { //向右
    			
    			res.add(m[hs][tempW++]);
    		}
    		while(tempH <= he) { //向下
    			res.add(m[tempH++][we]);
    		}
    		tempH--;
    		tempW--;
    		while(tempW > ws) { //向左
    			res.add(m[he][tempW--]);
    		}
    		while(tempH > hs) { //向上
    			res.add(m[tempH--][ws]);
    		}
    	}
    	
    }
    public static void main(String[] args) {
    	printMatrix test = new printMatrix();
    	int[][] t = new int[1][5];
    	int[] t1 = {1,2,3,4,5};
    	int[] t2 = {3,4};
    	int[] t3 = {5,6};
    	t[0] = t1;
//    	t[1] = t2;
//    	t[2] = t3;
    	System.out.println(test.printMatrix(t).toString());
    }

}
