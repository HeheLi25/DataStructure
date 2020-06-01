package jianZhiOffer;

public class RotateArray {
	public int minNumberInRotateArray(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[0])
				return array[i];
		}
		return 0;

	}

	public int minNumberInRotateArray2(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1;
			} else if (array[mid] == array[high]) {
				high = high - 1;
			} else {
				high = mid;
			}
		}
		return array[low];
	}

}
