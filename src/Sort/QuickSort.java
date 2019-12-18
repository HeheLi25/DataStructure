package Sort;

public class QuickSort {
	public static void devide(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		if(right < left) {
			return;
		}
		int base = arr[right];	//Step 1: Set the base value.
		while(right > left) {
			while(right > left && base >= arr[left]) left++; //Step 2: (1)When left value < base, continue.
			if(left < right) {									  	 //(2)when left value > base, exchange position.
				arr[right] = arr[left];
				arr[left] = base;
				right --;
			}
			while(right > left && base < arr[right]) right--;//Step 3: Do the same thing in reversal.
			if(left < right) {
				arr[left] = arr[right];
				arr[right] = base;
				left ++;
			}
		}
		devide(arr, start, right-1);
		devide(arr, right+1, end);
	}
	public static void sort(int[] arr) {
		if(arr!=null)devide(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{10,7,4,2,8,9,5,6,1,3};
		int[] b = null;
		int[] c = new int[] {};
		sort(a);
		sort(b);
		sort(c);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}
}
