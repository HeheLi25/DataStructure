package Sort;


public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,5,15,9,20,3,5,12,4,1,7};
		arr = sort(arr);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	
	
	public static int[] sort(int[] arr) {		
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

}
