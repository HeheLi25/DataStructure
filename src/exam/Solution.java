package exam;
import java.util.*;


public class Solution {
    /**
     * ����һ���ַ���,����ֻ������ĸ�ַ��͡�*���ַ�������������С�*��ȫ��Ų���ַ�������ߣ���ĸ�ַ��Ƶ��ַ������ұߡ���ɵ���������
     * @param input string�ַ��� ����һ���ַ�������chas��
     * @return string�ַ���
     */
    public static String rearrange (String input) {
    	if(input == null || input.length() == 0) return input;
    	char[] chars = input.toCharArray();
    	int pointer = -1;
    	for(int i = chars.length-1; i >= 0; i--) {
    		if(chars[i] == '*') {
    			if(pointer == -1) {
    				pointer = i;	//��¼��һ���Ǻŵ�λ��
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
     * �ж�һ��������Ӣ���ַ����Ƿ��ǻ��ģ����ĵ���˼��ǰ��Գ�λ�õ��ַ����  Ҫ�����ִ�Сд�����Ա����źͿո񣬿��ַ���������ġ�
     * @param text string�ַ��� �����ж��Ƿ��ǻ��ĵ��ַ���
     * @return bool������
     */
    public static boolean isPlaindrome (String text) {
    	if(text == null || text.length() == 0) return false;
    	text = text.toLowerCase();
 //       text = text.replaceAll("\\s*", "");
        text = text.replaceAll("[^0-9a-zA-Z]", "");
        System.out.println(text);
        char[] chars = text.toCharArray();
        int p1 = 0, p2 = chars.length -1;
        while(p2 - p1 > 1) {
        	if(chars[p1] != chars[p2]) {
        		System.out.println(chars[p1] + "," + chars[p2]);
        		return false;
        	}
        	p1++;
        	p2--;
        }
        return true;
    }
    
    /**
     * �������һ�������һ���������ó������г������ܹ����������ڸ��������Եĸ�����ע��ÿ��Ԫ��ֻ��ʹ��һ�Ρ���������ָ����������
     * @param array int����һά���� ��������
     * @param sum int���� ���Եĺ�
     * @return int����
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
    //�����ǿ��������㷨
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
    	String s = "`l;`` 1o1 ??;l`";
    	
    	System.out.println(isPlaindrome(s));
//    	int[] test = {1,7,7};
//    	System.out.println(twoSumCount(test, 8));
    	//System.out.println(isPlaindrome("a"));
    	//System.out.println(rearrange("o*f*f*e*r*"));
    }
}