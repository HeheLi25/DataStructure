package exam;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int num = s.nextInt();
		for(int i = 0; i < num; i++) {
			int page = s.nextInt();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < page; j++) {
				temp.add(s.nextInt());
			}
			list.add(temp);
		}
		for(ArrayList<Integer> l: list) {
			int sec = 0;   //当前这一分钟的秒数
			int page = 0;	//这一分钟内看的页数
			boolean flag = true;
			for(Integer i : l) {
				sec += i;
				page++;
				if(sec <= 60) { 
					if(page > 4) {	//还未超出一分钟，页面就大于4了，则判断不满足
						flag = false;
						System.out.println(0);
						break;
					}
					else if(sec == 60) {
						sec = 0;
						page = 0;
					}
				}else {	//超出一分钟，取超出部分重新开始计数
					sec = sec % 60;
					page = 1;
				}
			}
			if(flag == true)	//未出现不满足的情况则判断满足
				System.out.println(1);
		}
	}
	

}
