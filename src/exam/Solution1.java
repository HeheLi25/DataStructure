package exam;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class Solution1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()) {
			String str = s.nextLine();
			if(str.length() == 0) break;
			list.add(str);
		}
		for(String ss: list) {
			if(!judgeBrackets(ss))
				System.out.println(0);
			else
				System.out.println(1);
		}
	}
	
	public static boolean judgeBrackets(String s) {
		Stack<Character> stack = new Stack<Character>();
		ArrayList<String> other = new ArrayList<String>();
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(c == '[' || c == '(' || c == '{') {
				stack.push(c);
				i++;
				String middle = "";
				while(i < arr.length && arr[i] != ']' && arr[i] != ')' && arr[i] != '}') {
					middle += arr[i];
					i++;
				}
				other.add(middle);
				if(i >= arr.length) {
//					System.out.println("a");
					return false;
				}
			}
			c = arr[i];
			if(c == ']' || c == ')' || c == '}') {
				Character c1 = stack.pop();
				if((c1 == '(' && c != ')') || (c1 == '[' && c != ']') || (c1 == '{' && c != '}')) {
//					System.out.println("b");
					return false;
				}
			}
		}
		for(String mid: other) {
			if(!judgeOther(mid)) 
				return false;
		}
		
		
		return true;
	}
	public static boolean judgeOther(String s) {
//		s = s.replaceAll("\\s+", "");
		String[] nums = s.split(",");
		if(nums.length > 2) {
//			System.out.println("c");
			return false;
		}
		else if(nums.length <= 1) {		
			String[] words = s.split("\\|");
			if(s.contains("|")) {
				if(words.length <= 1) return false;
			}
			for(String word : words) {
				if(word == "" || word == "\n" || word == null || word.length() <= 1) {
//					System.out.println("d");
					return false;
				}
			}

		}else {
			if(Integer.parseInt(nums[0].trim()) > Integer.parseInt(nums[1].trim())) {
//				System.out.println("e");
				return false;
			}
		}
		
		return true;
	}

}
