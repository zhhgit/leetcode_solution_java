package session3.q122_best_time_to_buy_and_sell_stock_2;

public class Solution1 {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int dayLen = prices.length;
        if (dayLen == 0 || dayLen == 1){
            return 0;
        }
        int temp = 0;
        int sum = 0;
        for (int i = 1;i<dayLen;i++){
            int diff = prices[i] - prices[i-1];
            if (diff > 0){
                temp += diff;
            }
            else {
                sum += temp;
                temp = 0;
            }
        }
        sum += temp;
        return sum;
    }
}
