package exam;

import java.util.Scanner;
public class Tencent_Holiday {
    public static void main(String[] args) {
        //��һ�����ݴ������У����������ַ����������н���һ���ָ��Ȼ���ٵ��ú���ת����Ϊ��������
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //System.out.println(a);
        int[] works = new int[n+1];
        for(int i = 1; i <= n; i++){
            works[i] = in.nextInt();
        }
        int[] gyms = new int[n+1];
        for(int i = 1; i <= n; i++){
            gyms[i] = in.nextInt();
        }
        int res = holiday(n, works, gyms);
        System.out.println(res);
    }
     
    //���ԣ�ʹ��dp[i][0] dp[i][1] dp[i][2]�ֱ��¼�ڵ�i���������Ϣ����������������£�ǰi����������Ҳ����û��Ϣ�����������
    //�����i����Ϣ����ôǰi�������������������ʵ�ʾ���dp[i-1][0] dp[i-1][1] dp[i-1][2]�е����ֵ
    //�����i�칤������ôǰi�����������������������ǰһ����Ϣ�������е����ֵ + 1����Ϊ��i�칤���ˣ�û����Ϣ��
    //�����i�콡����ôǰi�����������������������ǰһ����Ϣ�������е����ֵ + 1����Ϊ��i�콡���ˣ�û����Ϣ��
    //���Ľ��������day��ȥ���������������������ٵ���Ϣʱ����
    public static int holiday(int day, int [] works, int [] gyms){
        int res;
        int [][] dp = new int[day+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < day+1; i++) {
            if(works[i] == 1){
                //��i�����ѡ����
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + 1;
            }
            if(gyms[i] == 1){
                //��i�����ѡ����
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + 1;
            }
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }
        res = day - Math.max(dp[day][0], Math.max(dp[day][1], dp[day][2]));
        return res;
    }
}
