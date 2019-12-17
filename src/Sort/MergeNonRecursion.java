package Sort;

import java.util.Arrays;

public class MergeNonRecursion {
	
	public static void merge(int a[], int[] tempA, int l, int r, int rightEnd) {
		//l = left start point; r = right start point; rightEnd = right end point;
		int leftEnd = r - 1;	//left end point;
		int temp = l;	//Start point of the result
		int numElements = rightEnd-l+1;
		while(l<=leftEnd && r<=rightEnd){
			if(a[l]<=a[r]) tempA[temp++] = a[l++];
			else tempA[temp++] = a[r++];
		}
		while(l <= leftEnd)
			tempA[temp++] = a[l++];//Copy everything left in left part.
		while(r <= rightEnd)
			tempA[temp++] = a[r++];//Copy everything left in right part. 
//		for(int i = 0; i < numElements; i++,rightEnd--)
//			a[rightEnd] = tempA[rightEnd];
	}
	
	public static void mergePass(int[] a, int[] tempA, int length) {
		int i;
		int n = a.length; 
		System.out.println("This is the round: length = "+length);
		for(i = 0; i <= n-2*length; i+=2*length) {
			merge(a,tempA, i, i+length, i+2*length-1);
			System.out.println("i = "+i);
		}
		System.out.println("i = "+i+" and out the loop.");
		if(i+length < n) {
			System.out.println("Merge the tail.");
			merge(a,tempA, i, i+length, n-1);
		}else{
			System.out.println("Copy the tail into the array");
			for(int j = i; j<n; j++) {
				tempA[j] = a[j];
			}
		}
	}
	
	public static void mergeSort(int[] a) {
		int[] tempA = new int[a.length];
		int length = 1;
		int n = a.length;
		while(length < n) {
			mergePass(a,tempA,length);
			length *= 2;
			mergePass(tempA,a,length);
			length *= 2;
		}
	}
	public static void main(String[] args) {
		int[] test = new int[] {3,9,8,7,1,5,11,4,10,2,6};
		mergeSort(test);
		System.out.println(Arrays.toString(test));
	}
}
