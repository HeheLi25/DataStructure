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
			int sec = 0;   //��ǰ��һ���ӵ�����
			int page = 0;	//��һ�����ڿ���ҳ��
			boolean flag = true;
			for(Integer i : l) {
				sec += i;
				page++;
				if(sec <= 60) { 
					if(page > 4) {	//��δ����һ���ӣ�ҳ��ʹ���4�ˣ����жϲ�����
						flag = false;
						System.out.println(0);
						break;
					}
					else if(sec == 60) {
						sec = 0;
						page = 0;
					}
				}else {	//����һ���ӣ�ȡ�����������¿�ʼ����
					sec = sec % 60;
					page = 1;
				}
			}
			if(flag == true)	//δ���ֲ������������ж�����
				System.out.println(1);
		}
	}
	

}
