package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge {
	
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
		for(int i = 0; i < numElements; i++,rightEnd--)
			a[rightEnd] = tempA[rightEnd];
	}
	
	public static void MSort(int a[], int[] tempA, int l, int rightEnd) {
		//  [L]=============[Center]============[RightEnd]
		int center;
		if(l<rightEnd) {
			center = (l+rightEnd) /2;
					MSort(a, tempA, l, center);
					MSort(a, tempA, center+1, rightEnd);
					merge(a, tempA, l, center+1, rightEnd);
		}
	}
	
	public static void mergeSort(int[] a) {
		int n = a.length;
		int[] tempA = new int[n];
		MSort(a, tempA, 0, n-1);
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {10,9,8,7,6,5,4,3,2,1};
//		int[] tempA = new int[test.length];
//		merge(test, tempA, 0, 5, test.length-1);

		mergeSort(test);
		System.out.println(Arrays.toString(test));
	}

}
