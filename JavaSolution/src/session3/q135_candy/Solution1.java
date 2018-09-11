package session3.q135_candy;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] [] ratingsArr = {{1,0,2},{1,2,2}};
        for (int[] ratings:ratingsArr){
            System.out.println(candy(ratings));
        }
    }

    private static int candy(int[] ratings) {
        int len = ratings.length;
        int[] res = new int[len];
        // 先填充1
        Arrays.fill(res, 1);
        // 后一个比前一个大，后一个为前一个+1
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }
        // 前一个比后一个大，前一个为后一个+1，和前一个本身的较大值（为了不破坏上一循环后一个比前一个大）
        for(int i = len - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
        }
        int sum = 0;
        for(int r: res) sum += r;
        return sum;
    }
}
