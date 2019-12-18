package Sort;

import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSort(int[] arr) {
		int temp;
		int i;
		for(int p = 1; p<arr.length; p++) {
			temp = arr[p]; //Get a new card.
			for(i = p; i>0 && arr[i-1]>temp; i--) arr[i]=arr[i-1]; //Prepare the position.
			arr[i] = temp; //New card get into the position.
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {10,7,4,2,8,9,5,6,1,3};
		arr = insertionSort(arr);
//		for(int i: arr) {
//			System.out.print(i+" ");
//		}
		System.out.println(Arrays.toString(arr));
	}

}
