package session1.q121_best_time_to_buy_and_sell_stock;

public class Solution2 {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices){
        int len = prices.length;
        int maxRet = 0,tempSum = 0;
        for(int i = 0; i < len-1; i++){
            tempSum+=(prices[i+1] - prices[i]);
            tempSum = Math.max(0,tempSum);
            maxRet = Math.max(maxRet,tempSum);
        }
        return maxRet;
    }
}
