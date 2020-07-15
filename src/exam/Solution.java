package exam;
import java.util.*;


public class Solution {
    /**
     * 给定一个字符串,其中只含有字母字符和“*”字符，现在想把所有“*”全部挪到字符串的左边，字母字符移到字符串的右边。完成调整函数。
     * @param input string字符串 输入一行字符串代表chas。
     * @return string字符串
     */
    public static String rearrange (String input) {
    	if(input == null || input.length() == 0) return input;
    	char[] chars = input.toCharArray();
    	int pointer = -1;
    	for(int i = chars.length-1; i >= 0; i--) {
    		if(chars[i] == '*') {
    			if(pointer == -1) {
    				pointer = i;	//记录第一个星号的位置
    			}
    		}else {
    			if(pointer != -1) {
    				chars[pointer] = chars[i];
    				chars[i] = '*';
    				pointer --;
    			}
    		}
    	}
    	String res = "";
    	for(char c : chars) {
    		res += c;
    	}
    	return res;
        
    }
    
    /**
     * 判断一个给定的英文字符串是否是回文，回文的意思是前后对称位置的字符相等  要求不区分大小写，忽略标点符号和空格，空字符串不算回文。
     * @param text string字符串 用于判断是否是回文的字符串
     * @return bool布尔型
     */
    public static boolean isPlaindrome (String text) {
    	if(text == null || text.length() == 0) return false;
    	text = text.toLowerCase();
        text = text.replaceAll("\\s*", "");
        text = text.replaceAll("\\p{P}", "");
        char[] chars = text.toCharArray();
        int p1 = 0, p2 = chars.length -1;
        while(p2 - p1 > 1) {
        	if(chars[p1] != chars[p2])
        		return false;
        	p1++;
        	p2--;
        }
        return true;
    }
    
    /**
     * 例如给定一个数组和一个整数，得出数组中出所有能够加起来等于该数的数对的个数。注意每个元素只能使用一次。（数对是指两个数。）
     * @param array int整型一维数组 整形数组
     * @param sum int整型 数对的和
     * @return int整型
     */
    public static int twoSumCount (int[] array, int sum) {
    	if(array == null || array.length == 0) return 0;
    	sort(array);
    	int p1 = 0;
    	int p2 = array.length-1 ;
    	int counter = 0;
    	while(p2 > p1) {
    		int add = array[p1] + array[p2];
    		if(add > sum)
    			p2--;
    		else if(add < sum)
    			p1++;
    		else {
    			counter ++;
    			p1++;
    		}
    	}
    	return counter;
    }
    //以下是快速排序算法
	public static void devide(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		if(right < left) {
			return;
		}
		int base = arr[right];
		while(right > left) {
			while(right > left && base >= arr[left]) left++; 
			if(left < right) {									  	 
				arr[right] = arr[left];
				arr[left] = base;
				right --;
			}
			while(right > left && base < arr[right]) right--;
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
    	int[] test = {1,7,7};
    	System.out.println(twoSumCount(test, 8));
    	//System.out.println(isPlaindrome("a"));
    	//System.out.println(rearrange("o*f*f*e*r*"));
    }
}