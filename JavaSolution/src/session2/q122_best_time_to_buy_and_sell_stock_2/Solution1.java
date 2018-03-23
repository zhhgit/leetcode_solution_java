package session2.q122_best_time_to_buy_and_sell_stock_2;

/**
 * Created by zhanghao1 on 2017/11/7.
 */
public class Solution1 {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int sum = 0;
        int temp = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i] > 0){
                temp += prices[i+1]-prices[i];
            }
            else{
                sum += temp;
                temp = 0;
            }
        }
        if(temp > 0){
            sum += temp;
        }
        return sum;
    }
}
