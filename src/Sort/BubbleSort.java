package Sort;


public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {10,7,4,2,8,9,5,6,1,3};
		arr = sort(arr);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	
	
	public static int[] sort(int[] arr) {		
		for(int i = 0; i<arr.length; i++) {
			int flag = 0;
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					flag = 1;
				}
			}
			if (flag == 0) break;
		}
		return arr;
	}

}
