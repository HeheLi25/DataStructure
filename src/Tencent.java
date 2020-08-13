import java.util.Scanner;
public class Tencent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        for(int i = 0; i < a; i++){
            arr[i] = in.nextInt();
        }
        sort(arr);
//        for(int i: arr) {
//        	System.out.print(i+" ");
//        }
        int ans = 0;
        for(int i = a-1; i>=0 ; i--){
            ans += arr[i];
            if((i-1) >= 0){
                ans -= arr[i-1];
                i--;
            }
        }
        System.out.println(ans);
    }     
	public static void sort(int[] arr) {
		if(arr!=null)devide(arr, 0, arr.length-1);
	}
    
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

	
}