package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			list.add(s.nextInt());
		}
		Collections.sort(list);
		int sum = 0;
		for(int i: list) {
			sum += i;
		}
		int sum2 = 0;
		for(int i: list) {
			sum2 += i;
			if(sum2 >= (sum+1)/2) {
				System.out.println(sum2);
				break;
			}
		}
	}
}
