package exam;

import java.util.Scanner;
public class Tencent_Holiday {
    public static void main(String[] args) {
        //第一步数据处理：三行，就是三个字符串，后两行进行一个分割处理，然后再调用函数转换成为整型数据
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
     
    //策略：使用dp[i][0] dp[i][1] dp[i][2]分别记录在第i天如果是休息、工作、健身情况下，前i天有事做（也就是没休息）的最大天数
    //如果第i天休息，那么前i天有事做的最大天数，实际就是dp[i-1][0] dp[i-1][1] dp[i-1][2]中的最大值
    //如果第i天工作，那么前i天有事做的最大天数，就是前一天休息、健身中的最大值 + 1（因为第i天工作了，没有休息）
    //如果第i天健身，那么前i天有事做的最大天数，就是前一天休息、工作中的最大值 + 1（因为第i天健身了，没有休息）
    //最后的结果，就用day减去最大的做事天数，就是最少的休息时间了
    public static int holiday(int day, int [] works, int [] gyms){
        int res;
        int [][] dp = new int[day+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < day+1; i++) {
            if(works[i] == 1){
                //第i天可以选择工作
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + 1;
            }
            if(gyms[i] == 1){
                //第i天可以选择健身
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + 1;
            }
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }
        res = day - Math.max(dp[day][0], Math.max(dp[day][1], dp[day][2]));
        return res;
    }
}
