package exam;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int len = c2.length;
		for(char c: c2) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else
				map.put(c, 1);
		}
		
		int right = 0, left = 0;
		for(int i = 0; i < c1.length; i++) {
			if(!map.containsKey(c1[i])) {
				map.put(c1[i], -1);
			}else {
				if(map.get(c1[i]) == -1) continue;
				else {
					map.put(c1[i], map.get(c1[i])-1);
					
					if(map.get(c1[i])>= 0) {
						len--;
					}
					if(len == 0) {
						right = i;
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < c1.length; i++) {
			if(map.get(c1[i]) == 0) {
				left = i;
				break;
			}
		}
		if(right == 0 && left == 0) System.out.println(0);
		else System.out.println(right - left +1);
	}
}
