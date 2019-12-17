package Sort;

import java.util.Arrays;

public class ShellSort {
	public static int[] shellSort(int[] arr) {
		int temp;
		int i;
		for (int d = arr.length / 2; d > 0; d = d / 2) {
			for (int p = d; p < arr.length; p++) {
				temp = arr[p]; 
				for (i = p; i >= d && arr[i - d] > temp; i = i - d)
					arr[i] = arr[i - d]; 
				arr[i] = temp; 
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {10,7,4,2,8,9,5,6,1,3};
		arr = shellSort(arr);
//		for(int i: arr) {
//			System.out.print(i+" ");
//		}
		System.out.println(Arrays.toString(arr));
	}
	

}
