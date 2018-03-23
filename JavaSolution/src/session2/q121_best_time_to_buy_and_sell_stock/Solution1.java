package session2.q121_best_time_to_buy_and_sell_stock;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < min) {
                min = prices[i];
            }
            if(prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
