package jianZhiOffer;

import java.util.HashSet;
import java.util.Set;

public class Array {
	public static boolean find(int target, int [][] array) {
		int k = array[0].length;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<k; j++) {
				System.out.println(array[i][j]);
				if(target == array[i][j]) return true;
				if(target < array[i][j]) k = j;
			}
		}return false;
	}
	public static boolean find2(int target, int [][] array) {
		int i = 0, j = array[0].length-1;
		while(j>=0 && i<array.length) {
			if(array[i][j]<target)i++;
			else if(array[i][j]>target)j--;
			else return true;
		}
		return false;
	}
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0; i<length; i++) {
			if(!s.add(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			}
		}return false;
	}
	 public static int[] multiply(int[] A) {
		 int[] B = new int[A.length];
		 
		 for(int i = 0; i<A.length;i++) {
			 B[i] = 1;
			 for(int j = 0; j<A.length; j++) {
				 
				 if(j == i)continue;
				 else B[i] *= A[j];
			 }
		 }
		 return B;
	 }
	
	
	public static void main(String[] args) {
		int[][] a = new int[][] {{1,3,8},{2,4,9}};
		int[] b = new int[] {1,2,6,5,4,2,5};
		int[] d = new int[1];
		int[] A = new int[] {1,2,3,4,5};
		int[] B = Array.multiply(A);
		for(int i:B) {
			System.out.println(i);
		}
	}

}
