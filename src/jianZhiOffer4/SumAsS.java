package jianZhiOffer4;

import java.util.ArrayList;

public class SumAsS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int len = array.length;
        int head = 0;
        int tail = len - 1;
        while(head < len && tail >= 0 && head < tail){
            int res = array[head] + array[tail];
            if(res > sum) tail --;
            else if(res < sum) head ++;
            else{
                ans.add(array[head]);
                ans.add(array[tail]);
                return ans;
            }
        }
        return ans;
    }

}
