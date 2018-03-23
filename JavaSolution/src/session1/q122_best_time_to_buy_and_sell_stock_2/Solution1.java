package session1.q122_best_time_to_buy_and_sell_stock_2;

public class Solution1 {
    public static void main(String[] args){
        int[] prices = {1,3,5,2,6,21,5,7};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int len = prices.length;
        int ret = 0,temp = 0;
        for(int i=0;i<len-1;i++){
            if((prices[i+1] - prices[i]) > 0){
                temp += prices[i+1] - prices[i];
            }
            else{
                ret += temp;
                temp = 0;
            }
        }
        if(temp>0){
            ret +=temp;
        }
        return ret;
    }
}
