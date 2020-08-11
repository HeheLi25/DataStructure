package exam;

import java.util.Scanner;

public class DJI2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int money = s.nextInt();
        int[][] snack = new int[3][n];
        for(int i = 0; i < n; i++){
            snack[0][i] = s.nextInt();
            snack[1][i] = s.nextInt();
            snack[2][i] = s.nextInt();
        }
        

    }
}
