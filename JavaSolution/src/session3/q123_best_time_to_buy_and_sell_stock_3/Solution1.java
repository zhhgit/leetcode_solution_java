package session3.q123_best_time_to_buy_and_sell_stock_3;

public class Solution1 {

    public static void main(String[] args){
        int[][] pricesArr = {{3,3,5,0,0,3,1,4},{1,2,3,4,5},{7,6,4,3,1}};
        for (int[] prices:pricesArr){
            System.out.println(maxProfit(prices));
        }
    }

    private static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1){
            return 0;
        }
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int i = 0;i<len;i++){
            int p = prices[i];
            // 第一次买时总钱数：假设初始资金为0，则为-p
            buy1 = Math.max(buy1,0 - p);
            // 第一次卖时总钱数
            sell1 = Math.max(sell1,p + buy1);
            // 第二次买时总钱数
            buy2 = Math.max(buy2, sell1 - p);
            // 第二次卖时总钱数
            sell2 = Math.max(sell2,p + buy2);
        }
        return sell2;
    }
}
