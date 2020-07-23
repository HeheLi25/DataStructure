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
    	if(we == ws) { //涓�绔栨帓
    		while(hs <= he) {
    			res.add(m[hs++][we]);
    		}
    	}
    	else if(he == hs) { //涓�妯帓
    		while(ws <= we) {
    			System.out.println(ws);
    			res.add(m[he][ws++]);
    		}
    	}else {
    		
    		int tempW = ws;
    		int tempH = hs;
    		while(tempW < we) { //鍚戝彸
    			
    			res.add(m[hs][tempW++]);
    		}
    		while(tempH <= he) { //鍚戜笅
    			res.add(m[tempH++][we]);
    		}
    		tempH--;
    		tempW--;
    		while(tempW > ws) { //鍚戝乏
    			res.add(m[he][tempW--]);
    		}
    		while(tempH > hs) { //鍚戜笂
    			res.add(m[tempH--][ws]);
    		}
    	}
    	
    }
    
        public ArrayList<Integer> printMatrix2(int [][] matrix) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            if(matrix.length == 0 || matrix[0].length == 0) return res;
            int x = matrix.length -1;
            int y = matrix[0].length -1;
            
            
            int s1 = 0, s2 = 0, e1 = x, e2 = y;
            while(e1 >= s1 && e2 >= s2){
                tool(matrix, res, s1++, s2++, e1--, e2--);
            }
            return res;
        }
        public void tool(int[][] matrix, ArrayList<Integer> res, int s1, int s2, int e1, int e2){
            if(s1 == e1)  { //一横排
                while(s2 <= e2)
                    res.add(matrix[s1][s2++]);
            }else if(s2 == e2){ //一竖排
                while(s1 <= e1)
                    res.add(matrix[s1++][s2]);
            }else{
                int tempS2 = s2;
                while(tempS2 <= e2)
                    res.add(matrix[s1][tempS2++]);
                int tempS1 = s1+1;
                while(tempS1 <= e1)
                    res.add(matrix[tempS1++][e2]);
                int tempE2 = e2-1;
                while(tempE2 >= s2)
                    res.add(matrix[e1][tempE2--]);
                int tempE1 = e1-1;
                while(tempE1 > s1)
                    res.add(matrix[tempE1--][s2]);
            }
        }
        public static int[][] buildMatrix(int n){
            if(n == 0) return new int[0][0];
            int counter = 0;
            int[][] matrix = new int[n][n];
            int x = 0, y = 0;
            int layer = n;
            while(layer > 1){
                for(int i = 0; i < layer-1; i++)
                    matrix[x][y++] = counter ++;
                for(int i = 0; i < layer-1; i++)
                    matrix[x++][y] = counter ++;
                for(int i = 0; i < layer-1; i++)
                    matrix[x][y--] = counter++;
                for(int i = 0; i < layer-1; i++)
                    matrix[x--][y] = counter++;
                x++;
                y++;
                layer-=2;
            }
            if(layer == 1){
                matrix[n/2][n/2] = counter;
            }
            return matrix;
        }
        
    public static void main(String[] args) {
    	printMatrix test = new printMatrix();
    	int[][] t = new int[2][8];
    	int[] t1 = {1,2,3,4,5,6,7,8};
    	int[] t2 = {9,10,11,12,13,14,15,16};
//    	int[] t3 = {15,16,17,18,19,20,21};
//    	int[] t4 = {22,23,24,25,26,27,28};
    	t[0] = t1;
    	t[1] = t2;
 //   	t[2] = t3;
//    	t[3] = t4;
 //   	System.out.println(test.printMatrix2(t).toString());
    	int[][] res = buildMatrix(7);
    	for(int i = 0; i < res.length; i++) {
    		for(int j = 0; j < res.length; j++) {
    			System.out.print(String.format("%-3d", res[i][j]));
    		}
    		System.out.println();
    	}
    }

}
