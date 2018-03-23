package session1.q121_best_time_to_buy_and_sell_stock;

public class Solution1 {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices){
        int max = 0,profit;
        int len = prices.length;
        if(len < 2){
            return max;
        }
        else{
            for(int i = 0; i < len-1; i++){
                for (int j = i+1; j < len; j++){
                    if(prices[j] > prices[i]){
                        profit = prices[j] - prices[i];
                        if(profit > max){
                            max = profit;
                        }
                    }
                }
            }
            return max;
        }
    }
}
