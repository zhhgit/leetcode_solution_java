package session3.q121_best_time_to_buy_and_sell_stock;

public class Solution1 {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxRet = 0;
        int dayLen = prices.length;
        if (dayLen == 0){
            return 0;
        }
        if (dayLen == 1){
            return 0;
        }
        int[] changes = new int[dayLen];
        changes[0] = 0;
        for (int i = 1;i<dayLen;i++){
            changes[i] = prices[i] - prices[i-1];
        }
        int sum = 0;
        for (int i = 1;i<dayLen;i++){
            sum += changes[i];
            if (sum < 0){
                sum = 0;
            }
            maxRet = Math.max(maxRet,sum);
        }
        return maxRet;
    }
}
